package org.minioa.core;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class Lang {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	private Map<String, Map<String, String>> prop;

	public void setProp(Map<String, Map<String, String>> data) {
		prop = data;
	}

	public Map<String, Map<String, String>> getProp() {
		if (prop == null){
			prop = new HashMap<String, Map<String, String>>();
			this.buildProperty("zh-cn.properties");
		}
		return prop;
	}
	@SuppressWarnings("unchecked")
	public void buildProperty(String fileName) {
		try {
			String filename = FunctionLib.getBaseDir() + fileName;
			File f = new File(filename);
			if (f.exists()) {
				InputStream is = new FileInputStream(filename);
				Properties property = new Properties();
				property.load(is);
				is.close();

				Map<String, String> t = new HashMap<String, String>();
				Iterator<?> it = property.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, String> e = (Entry<String, String>) it.next();
					t.put(e.getKey().toString(), e.getValue().toString());
				}
				prop.put("zh-cn", t);
			} else
				System.out.print("The file named " + filename + " not found!");
			f = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}