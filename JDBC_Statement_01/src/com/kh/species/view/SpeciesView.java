package com.kh.species.view;


import java.util.List;
import java.util.Scanner;

import com.kh.species.controller.SpeciesController;
import com.kh.species.model.dto.SpeciesDto;


public class SpeciesView {
	private Scanner sc = new Scanner(System.in);
	private SpeciesController speciesController = new SpeciesController();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println(" --- 종 관리 프로그램 --- ");
			System.out.println("1 : 종 추가하기");
			System.out.println("2 : 종 전체조회하기");
			System.out.println("3 : 종 정보변경하기");
			System.out.println("4 : 종 삭제하기");
			System.out.println("5 : 종 아아디 검색");
			System.out.println("6 : 종 이름 키워드 검색");
			System.out.println("9 : 프로그램 종료하기");
			System.out.println("---------------------");
			System.out.println();
			System.out.print("메뉴를 선택해주세요 >");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			case "5" : findById(); break;
			case "6" : findByKeyword(); break;
			case "9" : sc.close(); return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
	
	private void save() {
		
		System.out.println("종 추가를 선택하셨습니다.");
		System.out.print("종 이름 >");
		String speciesName = sc.nextLine();
		System.out.print("종 분류 >");
		String speciesClass = sc.nextLine();
		
		int result = speciesController.save(speciesName, speciesClass);
		if(result > 0) {
			System.out.println("종 추가가 추가됐습니다.");
		}else {
			System.out.println("종 추가가 실패했습니다.");
		}
	}
	
	private void findAll() {
		List<SpeciesDto>list = speciesController.findAll();
		System.out.println("\n종 전체 조회하기");
		System.out.println("존재하는 종의 수는 " +list.size()+"개 입니다.");
		if(list.isEmpty()) {
			System.out.println("존재하는 종이 없습니다.");
		}else {
			list.stream()
				.map(s -> "[종번호:" + s.getSpeciesId()
						+ ",종이름:" + s.getSpeciesName()
						+ ",종분류:" + s.getSpciesClass()
						+ "]")
				.forEach(System.out::println);
		}
	}
	
	private void update() {
		//Species_ID 값을 입력받아서
		//species_name과 species_class값을 수정하는 기능
		
		System.out.println("수정 기능을 선택하셨습니다.");
		System.out.print("수정 하실 종의 ID값 입력 >");
		String speciesId = sc.nextLine();
		System.out.print("수정 하실 종 이름 입력");
		String speciesName = sc.nextLine();
		System.out.print("수정 하실 종 분류 입력");
		String speciesClass = sc.nextLine();
		
		int result = speciesController.update(new SpeciesDto(speciesId, speciesName, speciesClass));
		
		if(result > 0) {
			System.out.println("종 변경에 성공했습니다.");
		}else {
			System.out.println("종 변경에 실패했습니다.");
		}
	}
	
	private void delete() {
		
		System.out.println("종 삭제 기능을 선택하셨습니다.");
		System.out.print("삭제 하실 종의 ID값 입력 >");
		String speciesId = sc.nextLine();
		
		int result = speciesController.delete(speciesId);
		
		if(result > 0) {
			System.out.println("삭제 성공했습니다.");
		} else {
			System.out.println("삭제 실패했습니다.");
		}
		
	}
	
	private void findById() {
		System.out.println("종 아이디 검색 기능을 선택하셨습니다.");
		System.out.print("검색 하실 종의 ID값 입력 >");
		String speciesId = sc.nextLine();
		
		SpeciesDto species = speciesController.findById(speciesId);
		if(species != null) {
			System.out.println("종 이름:"+species.getSpeciesName());
			System.out.println("종 분류:"+species.getSpciesClass());
		} else {
			System.out.println("존재하지 않는 ID입니다.");
		}
		
	}
	
	private void findByKeyword() {
		System.out.println("종 이름 키워드로 검색 기능을 선택하셨습니다.");
		System.out.print(" 검색 하실 종의 키워드를 입력 >");
		String keyword = sc.nextLine();
		
		List<SpeciesDto>list = speciesController.findByKeyword(keyword);
		if(list.isEmpty()) {
			System.out.println("존재하는 종이 없습니다.");
		}else {
			list.stream()
				.map(s -> "[종 이름:" + s.getSpeciesName()
						 +"종 분류:" + s.getSpciesClass()+ "]")
				.forEach(System.out::println);
		}
		
		
	}
	
}
