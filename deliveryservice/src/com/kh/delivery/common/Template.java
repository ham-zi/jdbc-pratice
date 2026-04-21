package com.kh.delivery.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource="mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			session = new SqlSessionFactoryBuilder().build(stream).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
		
	}

}
