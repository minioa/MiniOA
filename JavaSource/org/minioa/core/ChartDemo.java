package org.minioa.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ChartDemo {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-1-8
	 */
	private String fileName;

	public void setFileName(String data) {
		fileName = data;
	}

	public String getFileName() {
		return fileName;
	}

	private String filePath;

	public void setFilePath(String data) {
		filePath = data;
	}

	public String getFilePath() {
		return filePath;
	}

	public ChartDemo() {

	}

	private List<ChartDemo> items;

	public List<ChartDemo> getItems() {
		if (items == null)
			items = buildItems();
		return items;
	}

	public ArrayList<ChartDemo> buildItems() {
		ArrayList<ChartDemo> items = new ArrayList<ChartDemo>();
		try {
			items = new ArrayList<ChartDemo>();
			String dirPath = FunctionLib.getBaseDir() +"data-files";
			File dir = new File(dirPath);
			File[] files = listSortedFiles(dir);
			for (int i = 0; i < files.length; i++) {
				ChartDemo bean = new ChartDemo();
				bean.setFileName(files[i].getName());
				bean.setFilePath(files[i].getPath());
				if (bean.getFileName().endsWith("txt"))
					items.add(bean);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
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