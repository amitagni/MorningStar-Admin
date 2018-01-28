package com.ms.dao;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class CustomeDialect extends MySQLDialect {
	public CustomeDialect() {
		this.registerFunction("group_concat", new StandardSQLFunction("group_concat", Hibernate.STRING));
		this.registerFunction("coalesce", new StandardSQLFunction("coalesce", Hibernate.STRING));
		this.registerHibernateType(-1, Hibernate.TEXT.getName());
	}
}