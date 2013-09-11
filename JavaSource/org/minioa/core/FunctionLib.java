package org.minioa.core;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

public class FunctionLib {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	public static String dbType = "mysql";
	public static String baseDir, separator, webAppName, openfireAdmin, passwordKey;
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dtf2 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Map<String, String> systemProps;

	public static String getSeparator() {
		if (separator == null) {
			String osName = System.getProperty("os.name");
			if (osName == null)
				osName = "";
			if (osName.toLowerCase().indexOf("win") != -1)
				separator = "\\";
			else
				separator = "/";
		}
		return separator;
	}

	public static String getBaseDir() {
		if (baseDir == null)
			baseDir = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("baseDir") + getSeparator();
		return baseDir;
	}

	public static String getWebAppName() {
		if (webAppName == null)
			webAppName = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("webAppName");
		return webAppName;
	}
	
	public static String getPasswordKey() {
		if (passwordKey == null)
			passwordKey = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("passwordKey");
		return passwordKey;
	}

	public static String getWebParameter(String parameter) {
		return FacesContext.getCurrentInstance().getExternalContext().getInitParameter(parameter);
	}

	public static boolean isNum(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str).matches();
	}

	public static boolean isPhoneNum(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("\\d{3}-\\d{8}|\\d{4}-\\d{7}|\\d{11}", Pattern.CASE_INSENSITIVE);
		return pattern.matcher(str).matches();
	}
	
	public static boolean isDouble(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9|.]+");
		return pattern.matcher(str).matches();
	}

	public static boolean isEmail(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	public static boolean isImage(String fileName) {
		if (fileName == null)
			return false;
		Pattern pattern = Pattern.compile("(.*)(\\.png$|\\.jpg$|\\.jpeg$|\\.gif$|\\.bmp$|\\.ico$)", Pattern.CASE_INSENSITIVE);
		return pattern.matcher(fileName).matches();
	}

	public static boolean isDate(String date) {
		if (date == null)
			return false;
		try {
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getString(Object o) {
		if (o != null)
			return String.valueOf(o);
		else
			return "";
	}

	public static String getSubString8(String str) {
		if (str.length() > 8)
			return str.substring(0, 8);
		return str;
	}

	public static String getSubString15(String str) {
		if (str.length() > 15)
			return str.substring(0, 15);
		return str;
	}

	public static String getSubString18(String str) {
		if (str.length() > 18)
			return str.substring(0, 18);
		return str;
	}

	public static String getSubString24(String str) {
		if (str.length() > 24)
			return str.substring(0, 24);
		return str;
	}

	public static int getInt(Object o) {
		if (o != null) {
			if (!isNum(String.valueOf(o)))
				return 0;
			return Integer.valueOf(String.valueOf(o));
		} else
			return 0;
	}
	
	public static double getDouble(Object o) {
		if (o != null)
			return Double.valueOf(String.valueOf(o));
		else
			return 0;
	}

	public static boolean getBoolean(Object o) {
		if (o != null)
			return tinyint2Boolean(String.valueOf(o));
		else
			return false;
	}

	public static java.util.Date getDate(Object o) {
		if (o != null) {
			java.sql.Timestamp t = (java.sql.Timestamp) o;
			return new java.util.Date(t.getTime());
		} else
			return null;
	}

	public static String getDateString(Object o) {
		if (o != null) {
			java.sql.Timestamp t = (java.sql.Timestamp) o;
			return FunctionLib.df.format(new java.util.Date(t.getTime()));
		} else
			return "";
	}

	public static String getDateTimeString(Object o) {
		if (o != null) {
			java.sql.Timestamp t = (java.sql.Timestamp) o;
			return FunctionLib.dtf.format(new java.util.Date(t.getTime()));
		} else
			return "";
	}

	/**
	 * 将1转化成true，其它转化成false，针对MySQL数据库的TINYINT字段类型
	 * 
	 * @param str
	 *            0 or 1
	 * @return true or false
	 */
	public static boolean tinyint2Boolean(String str) {
		if ("1".equals(str))
			return true;
		else
			return false;
	}

	public static String gb23122Unicode(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= 256)
				sb.append("\\u00");
			else
				sb.append("\\u");
			sb.append(Integer.toHexString(str.charAt(i)));
		}
		return sb.toString();
	}

	/**
	 * 打开指定页面
	 * @param page
	 */
	public static void redirect(String page) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.sendRedirect("http://" + context.getExternalContext().getRequestHeaderMap().get("host") + "/" + page);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 打开指定页面
	 * @param templateName
	 * @param page
	 */
	public static void redirect(String templateName, String page) {
		try {
			if ("".equals(getWebAppName()))
				redirect("templates/" + templateName + "/" + page);
			else
				redirect(getWebAppName() + "/templates/" + templateName + "/" + page);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 打开指定url
	 * @param url
	 */
	public static void redirectUrl(String url) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.sendRedirect(url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void refresh() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.sendRedirect(context.getExternalContext().getRequestHeaderMap().get("referer"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void refresh(String oldStr, String newStr) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.sendRedirect(context.getExternalContext().getRequestHeaderMap().get("referer").replace(oldStr, newStr));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getRequestHeaderMap(String parameter) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestHeaderMap().get(parameter);
	}

	public static String exeSql(org.hibernate.Session s, String sql, String paramName, String paramValue, String type) {
		String str = "";
		if (type.equals("float"))
			str = "0";
		try {
			Query query = s.getNamedQuery(sql);
			query.setParameter(paramName, paramValue);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj = (Object) it.next();
				if (obj != null)
					str = String.valueOf(obj);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public static String exeSql(org.hibernate.Session s, String sql, String paramName, String paramValue, String paramName2, String paramValue2, String type) {
		String str = "";
		if (type.equals("float"))
			str = "0";
		try {
			Query query = s.getNamedQuery(sql);
			query.setParameter(paramName, paramValue);
			query.setParameter(paramName2, paramValue2);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj = (Object) it.next();
				if (obj != null)
					str = String.valueOf(obj);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public static String getIp() {
		String ip = "";
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("Proxy-Client-IP");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("WL-Proxy-Client-IP");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
				ip = request.getRemoteAddr();
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("via");
			if (ip == null || ip.length() == 0)
				ip = "unknown";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ip;
	}

	public static void download(String filename, String oldname, boolean fullpath) {
		if (fullpath)
			download(filename, oldname);
		else
			download(FunctionLib.getBaseDir() + filename, oldname);
	}

	public static void download(String filename, String oldname) {
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.responseComplete();
			String contentType = "application/x-download;charset=utf-8";
			HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
			response.setContentType(contentType);
			StringBuffer contentDisposition = new StringBuffer();
			contentDisposition.append("attachment;");
			contentDisposition.append("filename=\"");
			contentDisposition.append(oldname);
			contentDisposition.append("\"");
			response.setHeader("Content-Disposition", new String(contentDisposition.toString().getBytes(System.getProperty("file.encoding")), "iso8859_1"));
			ServletOutputStream out = response.getOutputStream();
			byte[] bytes = new byte[0xffff];
			File file = new File(filename);
			if (!file.exists())
				return;
			InputStream is = new FileInputStream(file);
			int b = 0;
			while ((b = is.read(bytes, 0, 0xffff)) > 0)
				out.write(bytes, 0, b);
			is.close();
			ctx.responseComplete();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean isDirExists(String dir) {
		try {
			File file = new File(dir);
			if (file.exists())
				return true;
			else
				return file.mkdirs();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static String getFileType(String fileName) {
		if (fileName.indexOf(".") > -1)
			return fileName.substring(fileName.lastIndexOf("."));
		else
			return "";
	}

	public static String getFileName(String path) {
		String fileName = path;
		if (path.indexOf("\\") > -1) {
			int i = path.lastIndexOf("\\") + 1;
			fileName = path.substring(i);
			return fileName;
		}
		if (path.indexOf("/") > -1) {
			int i = path.lastIndexOf("/") + 1;
			fileName = path.substring(i);
		}
		return fileName;
	}

	public static String getOpenfireProperty(Session s, String property) {
		String str = "";
		try {
			Query query = s.createSQLQuery("SELECT propValue FROM ofproperty where name=:property");
			query.setParameter("property", property);
			str = String.valueOf((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}
	
	
	public static int getIdByUUID(Session s,String tableName, String uuid) {
		int id = 0;
		try {
			Query query = s.createSQLQuery("select ID_ from " + tableName + " where UUID_ = :uuid");
			query.setParameter("uuid", uuid);
			id = getInt(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public static void sendOfMessage(String username, String messageText) {
		try {
			Application beanApp = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
			if (null == beanApp)
				return;
			if (beanApp.getInit() == 2) {
				MessageListener messageListener = new MessageListener() {
					@Override
					public void processMessage(Chat arg0, Message arg1) {
						;
					}
				};
				Chat chat = beanApp.getXmppConn().getChatManager().createChat(username + "@" + beanApp.getXmppConn().getServiceName(), messageListener);
				Message msg = new Message();
				msg.setBody(messageText + "\r\n" + dtf.format(new java.util.Date()));
				chat.sendMessage(msg);
				System.out.println("A short message has sent to " + username + " at time " + dtf.format(new java.util.Date()));
			} else
				System.out.println("The Xmpp is not Open!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 写入操作日志
	 * 
	 * @param s
	 *            数据库会话
	 * @param cId
	 *            操作人id
	 * @param ip
	 *            操作人ip
	 * @param tag
	 *            标签，或表名
	 * @param refId
	 *            相关表记录id
	 * @param summary
	 *            摘要
	 * @param details
	 *            sql明细
	 */
	public static void writelog(Session s, int cId, String ip, String tag, int refId, String summary, String details) {
		try {
			Query query = s.getNamedQuery("core.log.newrecord");
			query.setParameter("cId", cId);
			query.setParameter("tag", tag);
			query.setParameter("refId", refId);
			query.setParameter("summary", summary);
			query.setParameter("details", details);
			query.setParameter("ip", ip);
			query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Integer getTaskAgent(Session s, int taskDefId, int userId, int taskId) {
		Integer agent = 0;
		try {
			Query query = s.getNamedQuery("core.task.agent.getuseragent");
			query.setParameter("taskDefId", taskDefId);
			query.setParameter("cId", userId);
			query.setParameter("taskId", taskId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				agent = FunctionLib.getInt(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return agent;
	}

	public static Integer getProcessApplicantSuperior(Session s, Integer processId) {
		try {
			Query query = s.createSQLQuery("call core_getsuperior(:processId)");
			query.setParameter("processId", processId);
			return FunctionLib.getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static Integer getProcessApplicantManager(Session s, Integer processId) {
		try {
			Query query = s.createSQLQuery("call core_getmanager(:processId)");
			query.setParameter("processId", processId);
			return FunctionLib.getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String getUserDisplayNameByUserId(Session s, int userId) {
		try {
			Query query;
			query = s.getNamedQuery("core.user.getdisplaynamebyuserid");
			query.setParameter("userId", userId);
			return FunctionLib.getString((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public static int getUserIdByUserName(Session s, String userName) {
		try {
			Query query;
			query = s.getNamedQuery("core.user.getusernamebyuserid");
			query.setParameter("userName", userName);
			return FunctionLib.getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public static String getUserMailByUserId(Session s, int userId) {
		try {
			Query query;
			query = s.getNamedQuery("core.user.getmailbyuserid");
			query.setParameter("userId", userId);
			return FunctionLib.getString((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}


	public static String getDepaNameById(Session s, int depaId) {
		try {
			Query query;
			query = s.getNamedQuery("core.department.getdepanamebyid");
			query.setParameter("depaId", depaId);
			return FunctionLib.getString((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String getJobNameById(Session s, int jobId) {
		try {
			Query query;
			query = s.getNamedQuery("core.job.getjobnamebyid");
			query.setParameter("jobId", jobId);
			return FunctionLib.getString((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String getUsersByJobId(Session s, int jobId) {
		StringBuffer users = new StringBuffer();
		try {
			Query query = s.getNamedQuery("core.user.getusersbyjobid");
			query.setParameter("jobId", jobId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				users.append(FunctionLib.getString(o) + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users.toString();
	}

	public static String getRoleUsers(Session s, String roleName) {
		StringBuffer users = new StringBuffer();
		try {
			Query query = s.getNamedQuery("core.role.getusersbyname");
			query.setParameter("roleName", roleName);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				users.append(FunctionLib.getString(o) + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users.toString();
	}

	public static String getRoleUsers(Session s, int roleId) {
		StringBuffer users = new StringBuffer();
		try {
			Query query = s.getNamedQuery("core.role.getusersbyid");
			query.setParameter("id", roleId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				users.append(FunctionLib.getString(o) + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users.toString();
	}

	public static Integer getTaskApproverId(Session s, int taskDefId) {
		try {
			Query query = s.getNamedQuery("core.processdefinition.task.gettaskapproverid");
			query.setParameter("taskDefId", taskDefId);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static Integer getTaskApproverRoleId(Session s, int taskDefId) {
		try {
			Query query = s.getNamedQuery("core.processdefinition.task.gettaskapproverroleid");
			query.setParameter("taskDefId", taskDefId);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static Integer getTaskApproverJobId(Session s, int taskDefId) {
		try {
			Query query = s.getNamedQuery("core.processdefinition.task.gettaskapproverjobid");
			query.setParameter("taskDefId", taskDefId);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static Integer getTaskDefId(Session s, int processDefId, String taskCode) {
		try {
			Query query = s.getNamedQuery("core.processdefinition.task.gettaskdefid");
			query.setParameter("processDefId", processDefId);
			query.setParameter("taskCode", taskCode);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String getFormFieldName(Session s, int formId, String fieldText) {
		try {
			Query query = s.getNamedQuery("core.form.field.getname");
			query.setParameter("formId", formId);
			query.setParameter("fieldText", fieldText);
			return getString((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static int getLastProcessId(Session s, int processDefId, int instanceId) {
		try {
			Query query = s.getNamedQuery("core.process.getlastprocessid");
			query.setParameter("processDefId", processDefId);
			query.setParameter("instanceId", instanceId);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static int getLastRuningTaskDefId(Session s, int processId) {
		try {
			Query query = s.getNamedQuery("core.task.runningtaskdefid");
			query.setParameter("processId", processId);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String getProcessStatusText(String status) {
		try {
			if ("running".equals(status))
				return "<span style=\"color:blue;font-weight:bold;\">运行中</span>";
			else if ("agree".equals(status))
				return "<span style=\"color:green;font-weight:bold;\">已通过</span>";
			else if ("reject".equals(status))
				return "<span style=\"color:red;font-weight:bold;\">已拒绝</span>";
			else if ("takeback".equals(status))
				return "<span style=\"color:red;font-weight:bold;\">已收回</span>";
			else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static String getTaskStatusText(String status) {
		try {
			if ("running".equals(status))
				return "<span style=\"color:blue;font-weight:bold;\">运行中</span>";
			else if ("agree".equals(status))
				return "<span style=\"color:green;font-weight:bold;\">已通过</span>";
			else if ("confirm".equals(status))
				return "<span style=\"color:green;font-weight:bold;\">已查阅</span>";
			else if ("reject".equals(status))
				return "<span style=\"color:red;font-weight:bold;\">已拒绝</span>";
			else if ("cancel".equals(status))
				return "<span style=\"color:grey;font-weight:bold;\">已取消</span>";
			else if ("withdraw".equals(status))
				return "<span style=\"color:black;font-weight:bold;\">已退回</span>";
			else if ("takeback".equals(status))
				return "<span style=\"color:black;font-weight:bold;\">已收回</span>";
			else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static Boolean isArrayContains(String[] arr, String value) {
		try {
			for (int i = 0; i < arr.length; i++) {
				if (value.equals(arr[i]))
					return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static Boolean isArrayContains(String[] arr, Integer value) {
		try {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals(String.valueOf(arr[i])))
					return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 创建缩略图
	 * 
	 * @param fromFileStr
	 * @param saveToFileStr
	 * @param width
	 * @param hight
	 */
	public static void thumbnail(String oldfile, String newfile, int width, int hight) {
		try {
			BufferedImage srcImage;
			String imgType = "";
			if (oldfile.toLowerCase().endsWith(".gif"))
				imgType = "GIF";
			else if (oldfile.toLowerCase().endsWith(".png"))
				imgType = "PNG";
			else
				imgType = "JPEG";
			srcImage = ImageIO.read(new File(oldfile));
			if (width > 0 || hight > 0)
				srcImage = resize(srcImage, width, hight);
			ImageIO.write(srcImage, imgType, new File(newfile));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 缩略图，改变图片大小
	 * 
	 * @param source
	 * @param targetW
	 * @param targetH
	 * @return
	 */
	public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
		BufferedImage target = null;
		try {
			if (source == null)
				return null;
			// targetW，targetH分别表示目标长和宽
			int type = source.getType();
			double sx = (double) targetW / source.getWidth();
			double sy = (double) targetH / source.getHeight();
			// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
			// 则将下面的if else语句注释即可
			if (sx > sy) {
				sx = sy;
				targetW = (int) (sx * source.getWidth());
			} else {
				sy = sx;
				targetH = (int) (sy * source.getHeight());
			}
			if (type == BufferedImage.TYPE_CUSTOM) {
				ColorModel cm = source.getColorModel();
				WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
				boolean alphaPremultiplied = cm.isAlphaPremultiplied();
				target = new BufferedImage(cm, raster, alphaPremultiplied, null);
			} else
				target = new BufferedImage(targetW, targetH, type);
			Graphics2D g = target.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
			g.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return target;
	}

	public static Integer isSuperior(Session s, Integer cId, Integer userId, Integer level) {
		try {
			Query query = s.createSQLQuery("select core_issuperior(:cId,:userId,:level) from dual");
			query.setParameter("cId", cId);
			query.setParameter("userId", userId);
			query.setParameter("level", level);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static Integer isColleague(Session s, Integer cId, Integer userId, Integer level) {
		try {
			Query query = s.createSQLQuery("select core_iscolleague(:cId,:userId,:level) from dual");
			query.setParameter("cId", cId);
			query.setParameter("userId", userId);
			query.setParameter("level", level);
			return getInt((Object) query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String getFileSize(long size) {
		String fSize = "";
		if (size <= 1024)
			fSize = size + "B";
		if (size > 1024 && size <= 1024 * 1024)
			fSize = ((int) Math.round(((float) size / 1024) * 100)) / 100 + "K";
		if (size > 1024 * 1024)
			fSize = ((int) Math.round(((float) size / (1024 * 1024)) * 100)) / 100 + "M";
		return fSize;
	}
	
	public static boolean dirExists(String dir) {
		try {
			File file = new File(dir);
			if (file.exists())
				return true;
			else
				return file.mkdirs();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
