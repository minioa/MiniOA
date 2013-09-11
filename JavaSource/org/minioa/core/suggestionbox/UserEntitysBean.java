package org.minioa.core.suggestionbox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.model.SelectItem;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FunctionLib;
import org.xml.sax.SAXException;

public class UserEntitysBean {
	private ArrayList<UserEntity>	userentitys			= new ArrayList<UserEntity>();
	private ArrayList<String>		userEntitysNames	= new ArrayList<String>();
	private List<SelectItem>		userEntitysOptions	= new ArrayList<SelectItem>();
	private String					userEntity			= "";

	private String					currentDisplayNameFilterValue;
	private String					currentNameFilterValue;
	
	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	public List<UserEntity> autocomplete(Object suggest) {
		/*
		String pref = (String) suggest;
		ArrayList<UserEntity> result = new ArrayList<UserEntity>();
		Iterator<UserEntity> iterator = getUserEntitys().iterator();
		while (iterator.hasNext()) {
			UserEntity elem = ((UserEntity) iterator.next());
			if ((elem.getName() != null && elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || (elem.getDisplayName() != null && elem.getDisplayName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref)) {
				result.add(elem);
			}
		}
		return result;
		*/
		String pref = (String) suggest;
		ArrayList<UserEntity> result = new ArrayList<UserEntity>();
		Query query = getSession().getNamedQuery("core.user.getuserlistwithdepa");
		Iterator<?> it = query.list().iterator();
		while (it.hasNext()) {
			Object obj[] = (Object[]) it.next();
			UserEntity elem = new UserEntity();
			elem.setId(FunctionLib.getString(obj[0]));
			elem.setName(FunctionLib.getString(obj[1]));
			elem.setDisplayName(FunctionLib.getString(obj[2]));
			elem.setDepaName(FunctionLib.getString(obj[3]));
			if ((elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || (elem.getDisplayName().toLowerCase().indexOf(pref.toLowerCase()) > -1) || "".equals(pref)) {
				result.add(elem);
			}
		}
		return result;
	}

	public UserEntitysBean() {
		URL rulesUrl = getClass().getResource("userentitys-rules.xml");
		Digester digester = DigesterLoader.createDigester(rulesUrl);
		digester.push(this);
		/*
		try {
			digester.parse(getClass().getResourceAsStream("userentitys.xml"));
		} catch (IOException e) {
			throw new FacesException(e);
		} catch (SAXException e) {
			throw new FacesException(e);
		}
		*/
		userEntitysNames.clear();
		for (UserEntity item : userentitys) {
			userEntitysNames.add(item.getName());
		}
		userEntitysOptions.clear();
		for (UserEntity item : userentitys) {
			userEntitysOptions.add(new SelectItem(item.getName(), item.getDisplayName()));
		}
	}

	public void resetFilter() {
		setCurrentNameFilterValue("");
		setCurrentDisplayNameFilterValue("");
	}

	public String addUserEntity(UserEntity UserEntity) {
		userentitys.add(UserEntity);
		return null;
	}

	public ArrayList<UserEntity> getUserEntitys() {
		return userentitys;
	}

	public String getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(String data) {
		this.userEntity = data;
	}

	public List<SelectItem> getUserEntitysOptions() {
		return userEntitysOptions;
	}

	public ArrayList<String> getUserEntitysNames() {
		return userEntitysNames;
	}

	public String getCurrentStateFilterValue() {
		return currentDisplayNameFilterValue;
	}

	public void setCurrentDisplayNameFilterValue(String data) {
		this.currentDisplayNameFilterValue = data;
	}

	public String getCurrentNameFilterValue() {
		return currentNameFilterValue;
	}

	public void setCurrentNameFilterValue(String currentNameFilterValue) {
		this.currentNameFilterValue = currentNameFilterValue;
	}
}
