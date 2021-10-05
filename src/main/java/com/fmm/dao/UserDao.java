package com.fmm.dao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.Dependent;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;

import com.fmm.vo.UserVo;

@Dependent
public class UserDao extends BaseDao {
	
	public UserVo getUser(Integer id) {
		Map<String, Object> parMap = new HashMap<String, Object>();
		SqlSession session = getSqlSession("db1");
//		MappedStatement str = session.getConfiguration().getMappedStatement("com.fet.dao.mapping.basemapper.selectSQL");
//		System.out.println(str.getSqlSource());
		UserVo userVo = session.selectOne("com.fet.dao.mapping.basemapper.selectSQL", parMap);
		return userVo;
	}

	public Integer createUser(Integer id, String name) {
		Map<String, Object> parMap = new HashMap<String, Object>();
		parMap.put("id", id);
		parMap.put("name", name);
		SqlSession session = getSqlSession("db1");
		return session.insert("com.fet.dao.mapping.basemapper.selectSQL", parMap);
	}
}
