package com.kh.animal.common;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	//Connection 객체 생성~~ 하지 않고
	/*
	 * SqlSession 객체를 쓴다
	 * SqlSessionFactory
	 * SqlSessionFactoryBuilder로 팩토리 생성 -> 팩토리로 SqlSession 객체 생성
	 * XML설절파일에서 Bulder를 빌드할 수 있다.
	 * 
	 */
	
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		// mybatis-config.xml 파일에 작성한 environment요소의 내용을 읽어와서
		// 해당 DB와 연결된 Sqlssesion객체 생성
		
		String resource = "mybatis-config.xml";
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			
			// 1단계 : SqlSessionFactoryBuiler 만들기
			// -> 만드는방법 : 기본생성자를 호출한다.
			// 2단계 : SqlSessionFactory
			// -> 만드는방법 : Builder를 참조해서 메소드를 호출한다.
			//              .build(접속 내용을 담은 파일을 읽어온 입력스트림)
			// 3단게 : SqlSession 만들기
			// 만드는 법 : Factory를 참조해서 메소드를 호출한다.
			//           .openSession();
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	

	
}
