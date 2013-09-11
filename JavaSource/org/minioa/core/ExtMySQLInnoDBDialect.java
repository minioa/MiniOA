package org.minioa.core;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLInnoDBDialect;

public class ExtMySQLInnoDBDialect extends MySQLInnoDBDialect {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	public ExtMySQLInnoDBDialect() {
		super();
		registerHibernateType(-1, Hibernate.TEXT.getName());
	}
}
