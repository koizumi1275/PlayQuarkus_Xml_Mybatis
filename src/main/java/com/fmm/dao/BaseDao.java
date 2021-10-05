package com.fmm.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@ApplicationScoped
public class BaseDao {
	
	@Named("db1")
	private SqlSessionFactory sqlSessionFactory1;	
	
//	@Named("db2")
//	private SqlSessionFactory sqlSessionFactory2;	
	
	public SqlSession getSqlSession(String name)
	{
		if (name.equalsIgnoreCase("db1"))
			return sqlSessionFactory1.openSession();
//		else if (name.equalsIgnoreCase("db2"))
//			return sqlSessionFactory2.openSession();
		
		return null;
	}
}
