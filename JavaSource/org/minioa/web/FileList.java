package org.minioa.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.minioa.core.FunctionLib;
import org.minioa.core.MySession;

public class FileList {

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

	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}

	private List<FileList> recordsList;

	public List<FileList> getRecordsList() {
		if (recordsList == null)
			mRecordsList();
		return recordsList;
	}

	public FileList() {
	}

	public FileList(int i) {
	}

	public FileList(Map<String, String> data) {
		setProp(data);
	}

	public void mRecordsList() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String dirName = (String) params.get("dirName");
			if (dirName == null || "".equals(dirName))
				return;
			recordsList = new ArrayList<FileList>();
			Map<String, String> p;
			dirName = dirName.replaceAll("/", "\\\\");
			int l = dirName.split("\\\\").length;
			boolean tag = false;
			if(dirName.indexOf("\\..\\") > -1){
				dirName = dirName.replaceAll("\\\\..\\\\", "");
				tag = true;
			}
			
			if(l >= 3 && tag){
				dirName = dirName.substring(0,dirName.lastIndexOf("\\"));
			}
			mySession.getTempStr().put("dirName", dirName.replaceAll("\\\\", "/"));
			dirName = FunctionLib.getBaseDir() + dirName;			
			File dir = new File(dirName);
			File[] files = listSortedFiles(dir);
			if (files == null)
				return;

			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				recordsList.add(new FileList(size));
				size++;
				while (size < Integer.valueOf(mySession.getTempStr().get("FileList.size"))) {
					recordsList.add(new FileList(size));
					size++;
				}
				return;
			}
			mySession.getTempStr().put("FileList.size", String.valueOf(files.length));
			p = new HashMap<String, String>();
			p.put("id", String.valueOf(0));
			p.put("fileName", "");
			p.put("filePath", dir.getPath());
			if (dir.isDirectory())
				p.put("isDir", "Y");
			else
				p.put("isDir", "N");
			p.put("fileSize", FunctionLib.getFileSize(dir.length()));
			p.put("cDate",FunctionLib.dtf.format((new java.util.Date(dir.lastModified()))));
			recordsList.add(new FileList(p));
			for (int i = 1; i <= files.length; i++) {
				p = new HashMap<String, String>();
				p.put("id", String.valueOf(i));
				p.put("fileName", files[i-1].getName());
				p.put("filePath", files[i-1].getPath());
				if (files[i-1].isDirectory())
					p.put("isDir", "Y");
				else
					p.put("isDir", "N");
				p.put("fileSize", FunctionLib.getFileSize(files[i-1].length()));
				p.put("cDate",FunctionLib.dtf.format((new java.util.Date(files[i-1].lastModified()))));
				recordsList.add(new FileList(p));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void mDownload() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String dirName = (String) params.get("dirName");
			String fileName = (String) params.get("fileName");
			if (fileName == null || "".equals(fileName))
				return;

			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.responseComplete();
			String contentType = "application/x-download;charset=utf-8";
			HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
			response.setContentType(contentType);
			StringBuffer contentDisposition = new StringBuffer();
			contentDisposition.append("attachment;");
			contentDisposition.append("filename=\"");
			contentDisposition.append(fileName);
			contentDisposition.append("\"");
			response.setHeader("Content-Disposition", new String(contentDisposition.toString().getBytes(System.getProperty("file.encoding")), "iso8859_1"));
			ServletOutputStream out = response.getOutputStream();
			byte[] bytes = new byte[0xffff];

			File file = new File(FunctionLib.getBaseDir() + dirName + FunctionLib.getSeparator() + fileName);
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

	public void mDelete() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String filePath = (String) params.get("filePath");
			if (filePath == null || "".equals(filePath)) {
				getMySession().setMsg("文件不存在", 1);
				return;
			}
			File f = new File(filePath);
			if (f.exists()) {
				f.delete();
				getMySession().setMsg("文件已删除", 1);
			} else
				getMySession().setMsg("文件不存在", 1);
		} catch (Exception ex) {
			ex.printStackTrace();
			getMySession().setMsg("删除文件失败", 1);
		}
	}

	public void mSelect() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String fileName = (String) params.get("fileName");
			if (fileName == null || "".equals(fileName)) {
				getMySession().setMsg("文件不存在", 1);
				return;
			}
			prop = new HashMap<String, String>();
			prop.put("fileName", fileName);
		} catch (Exception ex) {
			ex.printStackTrace();
			getMySession().setMsg("选择文件失败", 1);
		}
	}

	public void mMakeDir() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String dirName = (String) params.get("dirName");
			if (dirName == null || "".equals(dirName))
				return;
			String fileName = prop.get("fileName");
			if (fileName == null || "".equals(fileName))
				return;
			fileName = fileName.replaceAll("\\*", "");
			fileName = fileName.replaceAll("\\\\", "");
			fileName = fileName.replaceAll("/", "");
			File file = new File(FunctionLib.getBaseDir() + dirName + FunctionLib.getSeparator() + fileName);
			if (file.exists())
				getMySession().setMsg("文件夹已存在", 1);
			else {
				file.mkdirs();
				getMySession().setMsg("已创建文件夹", 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getMySession().setMsg("创建文件夹失败", 2);
		}
	}

	public void mRenameDir() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String dirName = (String) params.get("dirName");
			if (dirName == null || "".equals(dirName))
				return;
			String oldName = (String) params.get("oldName");
			if (oldName == null || "".equals(oldName))
				return;
			String fileName = prop.get("fileName");
			if (fileName == null || "".equals(fileName))
				return;
			fileName = fileName.replaceAll("\\*", "");
			fileName = fileName.replaceAll("\\\\", "");
			fileName = fileName.replaceAll("/", "");

			File file = new File(FunctionLib.getBaseDir() + dirName + FunctionLib.getSeparator() + oldName);
			if (file.exists()) {
				file.renameTo(new File(FunctionLib.getBaseDir() + dirName + FunctionLib.getSeparator() + fileName));
				getMySession().setMsg("已重名文件夹", 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getMySession().setMsg("创建文件夹失败", 2);
		}
	}

	public void uploadListener(UploadEvent event) {
		Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String dirName = (String) params.get("dirName");
		if (dirName == null || "".equals(dirName))
			return;
		dirName = FunctionLib.getBaseDir() + dirName + FunctionLib.getSeparator();
		if (FunctionLib.dirExists(dirName)) {
			try {
				List<UploadItem> itemList = event.getUploadItems();
				for (int i = 0; i < itemList.size(); i++) {
					UploadItem item = (UploadItem) itemList.get(i);
					File file = new File(dirName + FunctionLib.getFileName(item.getFileName()));
					FileOutputStream out = new FileOutputStream(file);
					out.write(item.getData());
					out.close();
				}
				getMySession().setMsg("文件已上传", 1);
			} catch (Exception ex) {
				ex.printStackTrace();
				getMySession().setMsg("文件上传失败", 2);
			}
		}
	}

	// list sorted files
	public static File[] listSortedFiles(File dir) {
		assert dir.isDirectory();
		// 先读取文件夹
		File[] files = dir.listFiles();
		if (files == null)
			return null;

		int size = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory())
				size++;
		}
		FileWrapper[] fileWrappers = new FileWrapper[size];
		int j = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				fileWrappers[j] = new FileWrapper(files[i]);
				j++;
			}
		}
		Arrays.sort(fileWrappers);

		File[] sortedFiles = new File[files.length];
		for (int i = 0; i < size; i++) {
			sortedFiles[i] = fileWrappers[i].getFile();
		}
		// 再读取文件
		fileWrappers = new FileWrapper[files.length - size];
		j = 0;
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				fileWrappers[j] = new FileWrapper(files[i]);
				j++;
			}
		}
		Arrays.sort(fileWrappers);
		for (int i = 0; i < j; i++) {
			sortedFiles[i + size] = fileWrappers[i].getFile();
		}
		return sortedFiles;
	}
}

class FileWrapper implements Comparable<Object> {
	private File file;

	public FileWrapper(File file) {
		this.file = file;
	}

	public int compareTo(Object obj) {
		assert obj instanceof FileWrapper;
		FileWrapper castObj = (FileWrapper) obj;
		if (this.file.getName().compareTo(castObj.getFile().getName()) > 0) {
			return 1;
		} else if (this.file.getName().compareTo(castObj.getFile().getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public File getFile() {
		return this.file;
	}
}
