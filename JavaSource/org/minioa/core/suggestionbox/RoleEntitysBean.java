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

public class RoleEntitysBean {
	private ArrayList<RoleEntity>	roleentitys			= new ArrayList<RoleEntity>();
	private ArrayList<String>		roleEntitysNames	= new ArrayList<String>();
	private List<SelectItem>		roleEntitysOptions	= new ArrayList<SelectItem>();
	private String					roleEntity			= "";

	private String					currentDescFilterValue;
	private String					currentNameFilterValue;

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}
	
	public List<RoleEntity> autocomplete(Object suggest) {
		/*
		String pref = (String) suggest;
		ArrayList<RoleEntity> result = new ArrayList<RoleEntity>();

		Iterator<RoleEntity> iterator = getRoleEntitys().iterator();
		while (iterator.hasNext()) {
			RoleEntity elem = ((RoleEntity) iterator.next());
			if ((elem.getName() != null && elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || (elem.getDesc() != null && elem.getDesc().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref)) {
				result.add(elem);
			}
		}
		return result;
		*/
		String pref = (String) suggest;
		ArrayList<RoleEntity> result = new ArrayList<RoleEntity>();
		Query query = getSession().getNamedQuery("core.role.getrolelist");
		Iterator<?> it = query.list().iterator();
		while (it.hasNext()) {
			Object obj[] = (Object[]) it.next();
			RoleEntity elem = new RoleEntity();
			elem.setId(FunctionLib.getString(obj[0]));
			elem.setName(FunctionLib.getString(obj[1]));
			elem.setDesc(FunctionLib.getString(obj[2]));
			if ((elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || (elem.getDesc().toLowerCase().indexOf(pref.toLowerCase()) > -1) || "".equals(pref)) {
				result.add(elem);
			}
		}
		return result;
	}

	public RoleEntitysBean() {
		URL rulesUrl = getClass().getResource("roleentitys-rules.xml");
		Digester digester = DigesterLoader.createDigester(rulesUrl);
		digester.push(this);
		/*
		try {
			digester.parse(getClass().getResourceAsStream("roleentitys.xml"));
		} catch (IOException e) {
			throw new FacesException(e);
		} catch (SAXException e) {
			throw new FacesException(e);
		}
		*/
		roleEntitysNames.clear();
		for (RoleEntity item : roleentitys) {
			roleEntitysNames.add(item.getName());
		}
		roleEntitysOptions.clear();
		for (RoleEntity item : roleentitys) {
			roleEntitysOptions.add(new SelectItem(item.getName(), item.getDesc()));
		}
	}

	public void resetFilter() {
		setCurrentNameFilterValue("");
		setCurrentDescFilterValue("");
	}

	public String addRoleEntity(RoleEntity data) {
		roleentitys.add(data);
		return null;
	}

	public ArrayList<RoleEntity> getRoleEntitys() {
		return roleentitys;
	}

	public String getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(String data) {
		this.roleEntity = data;
	}

	public List<SelectItem> getRoleEntitysOptions() {
		return roleEntitysOptions;
	}

	public ArrayList<String> getRoleEntitysNames() {
		return roleEntitysNames;
	}

	public String getCurrentDescFilterValue() {
		return currentDescFilterValue;
	}

	public void setCurrentDescFilterValue(String data) {
		this.currentDescFilterValue = data;
	}

	public String getCurrentNameFilterValue() {
		return currentNameFilterValue;
	}

	public void setCurrentNameFilterValue(String currentNameFilterValue) {
		this.currentNameFilterValue = currentNameFilterValue;
	}
}
