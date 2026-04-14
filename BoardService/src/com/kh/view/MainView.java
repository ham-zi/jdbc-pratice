package com.kh.view;

import java.util.Scanner;

import com.kh.board.view.BoardView;
import com.kh.member.model.dto.MemberDto;
import com.kh.member.view.MemberView;

public class MainView {
	Scanner sc = new Scanner(System.in);

	public void mainView() {
		System.out.println("게시글 서비스에 오신걸 환영합니다.");
		MemberDto memberDto = new MemberView(sc).loginMenu();
		if(memberDto != null) {
			new BoardView(sc).boardView(memberDto);
		}
		
	}
}
