package com.kh.run;

import com.kh.model.dto.OracleDto;
import com.kh.view.View;

public class Run {

	public static void main(String[] args) {
		String user = "C##DS";
		String password = "DS";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		OracleDto dto =new OracleDto(url, user, password);
		new View(dto).menu();

		
	}

}
