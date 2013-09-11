package org.minioa.crm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class MailAttachment {

	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if(null == mySession)
			return null;
		if(!"true".equals(mySession.getIsLogin()))
			return null;
		return lang;
	}

	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if (mySession == null)
			FunctionLib.redirect(FunctionLib.getWebAppName());
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	private String init;

	public String getInit() {
		selectRecordById();
		return init;
	}

	private String uuid;

	public void setUuid(String data) {
		uuid = data;
	}

	public String getUuid() {
		return uuid;
	}

	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}

	private List<MailAttachment> items;

	public List<MailAttachment> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public MailAttachment() {
	}

	public MailAttachment(int i) {
	}

	public MailAttachment(Map<String, String> data) {
		setProp(data);
	}

	public void buildItems() {
		try {
			if(null == getMySession())
				return;
			items = new ArrayList<MailAttachment>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (null == uuid)
				uuid = getMySession().getTempStr().get("crm.mail.uuid");
			Query query = getSession().getNamedQuery("crm.mail.attachment.records");
			query.setParameter("uuid", uuid);
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			String url = "";
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));

				url = FunctionLib.getString(obj[6]);
				url = url.replaceAll("\\\\", "/");
				url = url.substring(url.indexOf("upload"));

				p.put("filename", url);
				p.put("filetype", FunctionLib.getString(obj[7]));
				p.put("filesize", FunctionLib.getString(obj[8]));
				p.put("oldname", FunctionLib.getString(obj[9]));
				p.put("uuid", uuid);
				items.add(new MailAttachment(p));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取一条记录
	 */
	public void selectRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id))
				selectRecordById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectRecordById(String id) {
		try {
			Query query = getSession().getNamedQuery("crm.mail.attachment.getrecordbyid");
			query.setParameter("id", id);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				prop = new HashMap<String, String>();
				prop.put("id", FunctionLib.getString(obj[0]));
				prop.put("uuid", FunctionLib.getString(obj[5]));
				prop.put("filename", FunctionLib.getString(obj[6]));
				prop.put("filetype", FunctionLib.getString(obj[7]));
				prop.put("filesize", FunctionLib.getString(obj[8]));
				prop.put("oldname", FunctionLib.getString(obj[9]));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("MailAttachment.id");
			//
			this.selectRecordById(id);
			if (prop != null && !"".equals(prop.get("filename"))) {
				File f = new File(FunctionLib.getBaseDir() + prop.get("filename"));
				if (f.exists())
					f.delete();
				Query query = getSession().getNamedQuery("crm.mail.attachment.deleterecordbyid");
				query.setParameter("id", id);
				query.executeUpdate();
				query = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
	
	public void deleteRecordsByUUID() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (null == uuid)
				uuid = getMySession().getTempStr().get("crm.mail.uuid");
			Query query = getSession().getNamedQuery("crm.mail.attachment.records");
			query.setParameter("uuid", uuid);
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("filename", FunctionLib.getString(obj[6]));
				p.put("filetype", FunctionLib.getString(obj[7]));
				p.put("filesize", FunctionLib.getString(obj[8]));
				p.put("oldname", FunctionLib.getString(obj[9]));
				p.put("uuid", uuid);
				File f = new File(FunctionLib.getBaseDir() + p.get("filename"));
				if (f.exists())
					f.delete();
				query = getSession().getNamedQuery("crm.mail.attachment.deleterecordbyid");
				query.setParameter("id", p.get("id"));
				query.executeUpdate();
				query = null;
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("MailAttachment.id", (String) params.get("id"));
			getMySession().getTempStr().put("crm.mail.uuid", (String) params.get("uuid"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void download() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				this.selectRecordById(id);
				FunctionLib.download(prop.get("filename"), prop.get("oldname"), false);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void uploadListener(UploadEvent event) {
		String storedir = "upload" + FunctionLib.getSeparator() + "mail" + FunctionLib.getSeparator();
		if (FunctionLib.isDirExists(FunctionLib.getBaseDir() + storedir)) {
			try {
				Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				String uuid = (String) params.get("uuid");
				if (uuid == null || uuid.equals(""))
					return;
				List<UploadItem> itemList = event.getUploadItems();
				for (int i = 0; i < itemList.size(); i++) {
					UploadItem item = (UploadItem) itemList.get(i);
					String newFileName = java.util.UUID.randomUUID().toString() + FunctionLib.getFileType(item.getFileName());
					File file = new File(FunctionLib.getBaseDir() + storedir + newFileName);
					FileOutputStream out = new FileOutputStream(file);
					out.write(item.getData());
					out.close();
					Query query = getSession().getNamedQuery("crm.mail.attachment.newrecord");
					query.setParameter("cId", getMySession().getUserId());
					query.setParameter("uuid", uuid);
					query.setParameter("filename", storedir + newFileName);
					query.setParameter("filetype", FunctionLib.getFileType(item.getFileName()));
					query.setParameter("filesize", String.valueOf(file.length()));
					query.setParameter("oldname", FunctionLib.getFileName(item.getFileName()));
					query.executeUpdate();
				}
			} catch (Exception ex) {
				String msg = getLang().getProp().get(getMySession().getL()).get("faield");
				getMySession().setMsg(msg, 2);
				ex.printStackTrace();
			}
		}
	}
}
