package com.kh.run;

import com.kh.view.View;

public class Run {

	public static void main(String[] args) {
		String user = "system";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		new View().mainMenu(url, user, password);

		
	}

}
