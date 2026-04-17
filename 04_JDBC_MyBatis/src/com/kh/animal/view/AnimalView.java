package com.kh.animal.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.animal.controller.AnimalController;
import com.kh.animal.controller.KeeperController;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class AnimalView {
	private Scanner sc = new Scanner (System.in);
	private AnimalController ac = new AnimalController();

	
	/*
	 * 메소드 네이밍 컨벤션
	 * ANIMAL
	 * 1. Mybatis
	 * insertAnimal
	 * selectAnimalList
	 * updateAnimal
	 * deleteAnimal
	 * 
	 * 2. JPA
	 * save
	 * findAll
	 * findByXXX
	 * update
	 * deleteByXXX
	 *
	 * 영속성 프레임워크에 따라 달라진다.
	 * 4단어 이하에서 끊어라.
	 */
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("동물 관리 시스템에 오신것을 환영");
			System.out.println("1. 동물 추가하기");
			System.out.println("2. 동물 전체 조회하기");
			System.out.println("3. 동물 단일 조회하기");
			System.out.println("4. 동물 이름 키워드로 조회하기");
			System.out.println("5. 사육사 및 담당동물 조회하기");
			System.out.println("6. 사육사 검색하기");
			System.out.println("7. 동물정보 수정하기");
			System.out.println("8. 동물정보 삭제하기");
			System.out.print("메뉴 선택 >");
			String menu = sc.nextLine();
			
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : findById(); break;
			case "4" : findByKeyword(); break;
			case "5" : selectKeeperAndAnimals();break;
			case "6" : selectKeeperByCondition();break;
			case "7" : updateAnimal();break;
			case "8" : deleteAnimal();break;
			case "9" : sc.close(); return;
			}
		}
	}
	
	private void save() {
		System.out.println("동물 추가 서비스입니다.");
		System.out.print("동물의 이름을 입력하세요 >");
		String name = sc.nextLine();
		
		System.out.print("동물의 종 번호를 입력하세요 > ");
		String speciesId = sc.nextLine();
		
		System.out.print("동물의 구역 번호를 입력하세요.");
		String zoneId = sc.nextLine();
		
		System.out.print("동물의 사육사번호를 입력하세요 >");
		String keeperId = sc.nextLine();
		
		System.out.print("동물의 성별을 입력하세요(M/F) >");
		String gender = sc.nextLine();
		
		System.out.print("동물의 몸무게를 입력하세요 >");
		double kg = sc.nextDouble();
		sc.nextLine();
		
		int result = ac.save(new AnimalDto(name, speciesId, zoneId,keeperId,gender, kg));
		
		if(result > 0) {
			System.out.println("생성 성공");
		} else {
			System.out.println("생성 실패");
		}
		
	}
	
	private void findAll() {
		System.out.println("========전체 목록========");
		List<AnimalDto>animals =  ac.findAll();
		//조회결과가 존재하지 않는다면 빈 리스트를 반환
		if(animals.isEmpty()) {
			System.out.println("존재하는 동물이 없습니다.");
		} else {
			animals.stream()
			       .map(a -> "[동물번호:" + a.getAnimalNo()
                         	+", 동물이름:" + a.getAnimalName()
                            +", 지역이름:" + a.getZoneId()
                            +", 사육사이름:" + a.getKeeperId()
                            +", 성별:" + a.getGender()
                            +", 몸무게:" + a.getWeightKg()
                            +"]" )
                   .forEach(System.out::println);
		}
	}
	
	private void findById() {
		System.out.println("동물 찾기 서비스");
		System.out.print("검색하실 동물의 ID를 입력해주세요");
		String id = sc.nextLine();
		
		AnimalDto animal = ac.findById(id);
		
		if(animal==null) {
			System.out.println("존재하는 동물이 없습니다.");
		} else {
			System.out.println(animal.getAnimalNo() +"의 정보");
			System.out.println("동물이름:"+animal.getAnimalName());
			System.out.println("종이름 :"+animal.getSpeciesId());
			System.out.println("구역이름:" +animal.getZoneId());
			System.out.println("사육사이름:" +animal.getKeeperId());
			System.out.println("성별:" + animal.getGender());
			System.out.println("몸무게:" +animal.getWeightKg());
		}
		
	}
	
	private void findByKeyword() {
		System.out.println("동물 이름 키워드 조회하기");
		System.out.print("검색하실 동물의 이름 키워드 입력");
		String name = sc.nextLine();
		
		List<AnimalDto> animals = ac.findByKeyword(name);
		
		if(animals.isEmpty()) {
			System.out.println("존재하는 동물이 없습니다.");
		} else {
			for(AnimalDto a : animals) {
				System.out.println(a);
			}
		}
	}
	
	private void selectKeeperAndAnimals() {
		//사육사 전체 조회 + 각 사육사들의 담당하는 애니멀 전체조회
		//List<KeeperDto> keepers = new KeeperController().selectKeeperAndAnimals();
		List<KeeperDto>keepers = new KeeperController().findKeeperAndAnimals();
		for(KeeperDto keeper : keepers) {
			System.out.println(keeper.getAnimals());
			System.out.println("=========================");
		}
	}
	
	private void selectKeeperByCondition() {
		// sql를 3개를 따로 만들거나 
		// sql를 1개에다가 where 에 or/ or /or를 넣어서 복잡하게 구성하기 
		
		// MyBatis에 이런 문제를 처리하는 강력한 기능이 있다.
		System.out.println("사육사 검색 서비스입니다.");
		System.out.print("검색 조건을 선택해주세요 >");
		System.out.println("1. 사육사 번호");
		System.out.println("2. 사육사 이름");
		System.out.println("3. 담당 구역");
		System.out.print("메뉴 번호 입력 >");
		String menuNo = sc.nextLine();
		System.out.print("검색하실 키워드를 입력해주세요>");
		String keyword = sc.nextLine();
		// 포함되면 다 찾기
		Map<String,String> arguments = new HashMap<>();
		arguments.put("menuNo", menuNo);
		arguments.put("keyword", keyword);
		List<KeeperDto>list = new KeeperController().selectKeeperByCondition(arguments);
		if(list.isEmpty()) {
			System.out.println("존재하는 사육사가 없습니다.");
		} else {
			for(KeeperDto dto : list) {
				System.out.println(dto);
			}
		}
		
	}
	
	private void updateAnimal() {
		
		System.out.println("동물 정보 변경 서비스입니다.");
		findAll();
		System.out.print("정보를 변경하실 동물의 번호를 입력해주세요 >");
		String animalNo = sc.nextLine();
		System.out.print("변경하실 구역 번호를 입력해주세요 > ");
		String zoneId = sc.nextLine();
		System.out.print("변경하실 사육사 번호를 입력해주세요 >");
		String keeperId = sc.nextLine();
		System.out.print("변경하실 몸무게를 입력해주세요.");
		double weightKg = sc.nextDouble();
		sc.nextLine();
		
		AnimalDto animal = new AnimalDto();
		animal.setAnimalNo(animalNo);
		animal.setZoneId(zoneId);
		animal.setKeeperId(keeperId);
		animal.setWeightKg(weightKg);
		int result = ac.updateAnimal(animal);
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	
	private void deleteAnimal() {
		System.out.println("동물 정보 삭제 서비스입니다.");
		findAll();
		System.out.print("삭제하실 동물의 번호를 입력하세요 >");
		String animalNo = sc.nextLine();
		int result = ac.deleteAnimal(animalNo);
		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
	
	
}
