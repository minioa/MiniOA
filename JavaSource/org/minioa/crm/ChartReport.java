package org.minioa.crm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;

public class ChartReport {
	/**
	 * 获取名为Lang的javabean
	 */
	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if (lang == null)
			FunctionLib.redirect(FunctionLib.getWebAppName());
		return lang;
	}

	/**
	 * 获取名为MySession的javabean，用于获取当前用户的会话数据
	 */
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

	/**
	 * 创建一个数据连接会话
	 */
	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}
	
	public ChartReport() {
	}

	public void buildReportDiqu() {
		try {
			getMySession();
			StringBuffer value = new StringBuffer();
			Query query = getSession().createSQLQuery("SELECT shengfen,count(*) FROM crm_customer group by shengfen order by shengfen");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				value.append(",{\"value\":"+ FunctionLib.getInt(obj[1]) +",\"label\":\""+ FunctionLib.getString(obj[0]) +"\", \"tip\":\""+ FunctionLib.getString(obj[0]) +"\"}");
			}
			String values = value.toString();
			if (value.length() > 1)
				values = values.substring(1);
			
			StringBuffer bf = new StringBuffer();
			bf.append("{\r\n");
			bf.append("\r\n");
			bf.append("  \"title\":{\r\n");
			bf.append("    \"text\":\"客户分布图\",\r\n");
			bf.append("    \"style\":\"{font-size: 30px;}\"\r\n");
			bf.append("  },\r\n");
			bf.append("\r\n");
			bf.append("  \"elements\":[\r\n");
			bf.append("    {\r\n");
			bf.append("      \"type\":      \"pie\",\r\n");
			bf.append("      \"colours\":   [\"#d01f3c\",\"#356aa0\",\"#C79810\",\"#0247fe\", \"#3d01a4\", \"#8601af\", \"#a7194b\", \"#fe2712\", \"#fd5308\", \"#fb9902\", \"#fabc02\", \"#fefe33\", \"#d0ea2b\", \"#66b032\", \"#0392ce\"],\r\n");
			bf.append("      \"alpha\":     0.6,\r\n");
			bf.append("      \"border\":    2,\r\n");
			bf.append("      \"start-angle\": 35,\r\n");
			bf.append("      \"values\" :   [\r\n");
			bf.append("        "+ values +"\r\n");
			bf.append("      ]\r\n");
			bf.append("    }\r\n");
			bf.append("  ]\r\n");
			bf.append("}\r\n");

			long t = new java.util.Date().getTime();
			String filename = FunctionLib.getBaseDir() + "temp/chart/crm" + t + ".txt";
			File f = new File(filename);
			if (f.exists())
				f.delete();
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
			out.write(bf.toString());
			out.close();
			FunctionLib.redirect("default", "crm/chart.jsf?ofc=../../../temp/chart/crm" + t + ".txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void buildReportVisit() {
		try {
			getMySession();
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("CrmChartReport.startDate") != null)
					startDate = mySession.getTempDate().get("CrmChartReport.startDate");
				if (mySession.getTempDate().get("CrmChartReport.endDate") != null)
					endDate = mySession.getTempDate().get("CrmChartReport.endDate");
			}
			if(startDate == null)
				startDate = FunctionLib.df.parse("2012-01-01");
			if(endDate == null)
				endDate = FunctionLib.df.parse("2012-12-31");
			
			StringBuffer value = new StringBuffer();
			StringBuffer label = new StringBuffer();
			Query query = getSession().createSQLQuery("select tb.displayName, aa.count from (SELECT ta.CID_,count(*) as count FROM crm_visit ta where ta.lianxirq between :startDate and :endDate group by ta.CID_) aa left join core_user tb on tb.ID_  = aa.CID_");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				label.append(",\"" + FunctionLib.getString(obj[0]) + "\"");
				value.append("," +  FunctionLib.getInt(obj[1]));
			}
			String values = value.toString();
			if (value.length() > 1)
				values = values.substring(1);
			String labels = label.toString();
			if (labels.length() > 1)
				labels = labels.substring(1);

			StringBuffer bf = new StringBuffer();
			bf.append("{");
			bf.append("\r\n  \"title\":{");
			bf.append("\r\n    \"text\":  \"业务经理拜访记录统计\",");
			bf.append("\r\n    \"style\": \"{font-size: 16px; color:#00000; font-family: 楷体_GB2312; text-align: center;font-weight:bold;}\"");
			bf.append("\r\n  },");
			bf.append("\r\n  \"elements\":[");
			bf.append("\r\n    {");
			bf.append("\r\n      \"type\":      \"bar_glass\",");
			bf.append("\r\n      \"alpha\":     0.7,");
			bf.append("\r\n      \"colour\":    \"#9933CC\",");
			bf.append("\r\n      \"text\":      \"百分比\",");
			bf.append("\r\n      \"on-show\":	{\"type\": \"grow-up\"},");
			bf.append("\r\n      \"font-size\": 10,");
			bf.append("\r\n      \"values\" :   [" + values + "]");
			bf.append("\r\n    }");

			bf.append("\r\n  ],");
			bf.append("\r\n  \"y_axis\":{");
			bf.append("\r\n    \"stroke\":      4,");
			bf.append("\r\n    \"tick_length\": 3,");
			bf.append("\r\n    \"colour\":      \"#909090\",");
			bf.append("\r\n    \"grid_colour\": \"#d0d0d0\",");
			bf.append("\r\n    \"offset\":      0,");
			bf.append("\r\n    \"steps\":      10,");
			bf.append("\r\n    \"max\":         150");
			bf.append("\r\n  },");
			bf.append("\r\n  	\"x_axis\":{");
			bf.append("\r\n		\"offset\":8,");
			bf.append("\r\n		\"stroke\":1,");
			bf.append("\r\n		\"colour\":\"#c6d9fd\",");
			bf.append("\r\n		\"grid-colour\":\"#dddddd\",");
			bf.append("\r\n		\"labels\":{");
			bf.append("\r\n			\"labels\":[" + labels + "]");
			bf.append("\r\n			}");
			bf.append("\r\n		},");
			bf.append("\r\n	\"bg_colour\":\"#ffffff\"");
			bf.append("\r\n}");
			
			long t = new java.util.Date().getTime();
			String filename = FunctionLib.getBaseDir() + "temp/chart/crm" + t + ".txt";
			File f = new File(filename);
			if (f.exists())
				f.delete();
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
			out.write(bf.toString());
			out.close();
			FunctionLib.redirect("default", "crm/chart.jsf?ofc=../../../temp/chart/crm" + t + ".txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
