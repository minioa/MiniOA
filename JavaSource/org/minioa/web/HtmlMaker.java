package org.minioa.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FunctionLib;
import org.minioa.core.MySession;

public class HtmlMaker {
	
	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if(null == mySession)
			return null;
		if(!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}
	
	public HtmlMaker(){
		
	}
	
	public void makefile() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if(FunctionLib.isNum(id)){
				makefile(Integer.valueOf(id));
				getMySession().setMsg("已生成静态网页", 1);
			}
		} catch (Exception ex) {
			getMySession().setMsg("生成静态网页时遇到错误，请检查", 2);
			ex.printStackTrace();
		}
	}
	
	public void makefile(int id) {
		try {
			HtmlProp html = new HtmlPropDao().selectRecordById(id);
			String content = getPropValue("template.html");
			content = content.replaceAll("#\\{body\\}", html.getPropValue());
			if(html.getTitle()!=null && !html.getTitle().equals(""))
				content = content.replaceAll("#\\{网站名称\\}", html.getTitle());
			if(html.getKeywords()!=null && !html.getKeywords().equals(""))
				content = content.replaceAll("#\\{网站关键词\\}", html.getKeywords());
			if(html.getDescription()!=null && !html.getDescription().equals(""))
				content = content.replaceAll("#\\{网站描述\\}", html.getDescription());
			content = compile(content);
			content = compile(content);
			content = compile(content);
			//生成网页模版
			String filename = FunctionLib.getBaseDir() + "web" + FunctionLib.getSeparator() + html.getPropName();
			File f = new File(filename);
			if (f.exists())
				f.delete();
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
			out.write(content);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void makefiles() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String xtype = (String) params.get("xtype");
			if(xtype.equals("file")){
				Criteria criteria = getSession().createCriteria(HtmlProp.class);
				criteria.add(Restrictions.eq("propType", xtype));
				criteria.addOrder(Order.desc("propName"));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					HtmlProp bean = (HtmlProp) it.next();
					makefile(bean.getID_());
				}
				it = null;
				getMySession().setMsg("已生成静态网页", 1);
			}
		} catch (Exception ex) {
			getMySession().setMsg("生成静态网页时遇到错误，请检查", 2);
			ex.printStackTrace();
		}
	}
	
	public void makesitemap() {
		try {
			getMySession();

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String xtype = (String) params.get("xtype");
			if(xtype.equals("file")){
				StringBuilder sb = new StringBuilder();
				Criteria criteria = getSession().createCriteria(HtmlProp.class);
				criteria.add(Restrictions.eq("propType", xtype));
				criteria.addOrder(Order.desc("propName"));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					HtmlProp bean = (HtmlProp) it.next();
					sb.append("<url>\r\n");
					sb.append("<loc>http://www.qdrcjs.com/"+ bean.getPropName() +"</loc>\r\n");
					sb.append("<priority>0.8</priority>\r\n");
					if(bean.getMDATE_()==null)
						sb.append("<lastmod>"+ bean.getCDATE_() +"</lastmod>\r\n");
					else
						sb.append("<lastmod>"+ bean.getMDATE_() +"</lastmod>\r\n");
					sb.append("<changefreq>Always</changefreq>\r\n");
					sb.append("</url>\r\n");
				}
				it = null;
				
				String content = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FunctionLib.getBaseDir() + "web" + FunctionLib.getSeparator() + "sitemap.template.xml"), "UTF-8"));
				String line = null;
				StringBuilder sbContent = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sbContent.append(line + "\r\n");
				}
				br.close();

				content = sbContent.toString().replaceAll("#\\{body\\}", sb.toString());
				//生成网页模版
				String filename = FunctionLib.getBaseDir() + "web" + FunctionLib.getSeparator() + "sitemap.xml";
				File f = new File(filename);
				if (f.exists())
					f.delete();
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
				out.write(content);
				out.close();
				
				getMySession().setMsg("已生成网站地图", 1);
			}
		} catch (Exception ex) {
			getMySession().setMsg("生成静态网页时遇到错误，请检查", 2);
			ex.printStackTrace();
		}
	}
	
	public String getPropValue(String propName) {
		String str = "";
		try {
			Query query = getSession().createSQLQuery("select ifnull((select propValue from web_prop where propName = :propName limit 1),'') as v");
			query.setParameter("propName", propName);
			str = String.valueOf((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}
	
	public String compile(String content){
		try
		{
			String reg = "#\\{([0-9a-zA-Z\\.\\u4e00-\\u9fa5]*)\\}";
			Pattern pat = Pattern.compile(reg, Pattern.DOTALL);
			Matcher mac = pat.matcher(content);
			String str = "";
			while (mac.find()) {
				str = mac.group(1);
				content = content.replaceAll("#\\{"+ str +"\\}", getPropValue(str));
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return content;
	}

}
