package miniproject_country.com.kh.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import miniproject_country.com.kh.city.controller.CityController;
import miniproject_country.com.kh.city.model.dto.CityDto;
import miniproject_country.com.kh.province.controller.ProvinceController;
import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class CountryView {
		
	private Scanner sc = new Scanner(System.in);
	private ProvinceController pc = new ProvinceController();
	private CityController cc = new CityController();
	
	public void mainMenu() {
		while(true) {
	    System.out.println();
		System.out.println("==========================");
		System.out.println("도시 정보공유 서비스 입니다.");
		System.out.println("1 : 행정구역'도' 전체 조회");
		System.out.println("2 : 행정구역'도' 상세 조회");
		System.out.println("3 : 도시(city) 전체 조회");
		System.out.println("4 : 도시(city) 상세 조회");
		System.out.println("5 : 키워드 명소 조회");
		System.out.println("6 : 특정 특산물 조회");
		System.out.println("7 : 행정구역'도' 단위 명소 조회");
		System.out.println("8 : 행정구역'도' 단위 특산물 조회");
		System.out.println("9 : 행정구역'도' 정보 관리");
		System.out.println("10 : 행정구역'시' 정보 관리");
		System.out.println("11 : 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴를 선택해주세요 >");
		String menuNum = sc.nextLine();
		
		
		switch(menuNum) {
		case "1": selectProvinces(); break;
		case "3": selectCities(); break;
		case "9": provinceMenu(); break;
		case "10": cityMenu(); break;
		case "11": sc.close(); return;
		default : System.out.println("없는 메뉴입니다.");
		
		}
		
		
		}
	}

	
	private void cityMenu() {
		while(true) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("행정구역'시' 정보 관리 시스템");
			System.out.println("1 : 행정구역'시' 추가하기");
			System.out.println("2 : 행정구역'시' 수정하기");
			System.out.println("3 : 행정구역'시' 삭제하기");
			System.out.println("4 : 관리 시스템 종료");
			System.out.println("==========================");
			System.out.print("메뉴를 선택해주세요 >");
			String menuNum = sc.nextLine();
			switch(menuNum) {
			case "1": insertCity();break;
			case "2": updateCity();break;
			case "3": deleteCity();return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
	private void selectCities() {
		System.out.println("=========================");
		List<CityDto> cities = cc.selectCities();
		if(cities.isEmpty()) {
			System.out.println("존재하는 '도'가 없습니다.");
		} else {
			cities.stream()
				     .map(c->"[도시고유번호:"+c.getCityNo()
				           +" ,도시이름:"+c.getCityName()
				           +" ,도시인구수:"+c.getCityPopulation()+"명"
				           +" ,도시면적:"+c.getCityArea()+"제곱미터"
				           +" ,명소:"+c.getHotPlace()//여러개 될수도 있음
				           +" ,특산물:"+c.getLocalProduct()
				           +" ,소속:"+c.getProvinceNo()
				           +"]")
				     .forEach(System.out::println);
		}
	}
	
	private void insertCity() {
		selectProvinces();
		Long cityPopulation;
		Long cityArea;
		int provinceNo;
		System.out.println("도시 추가");
		System.out.print("도시 이름 입력 >");		
		String cityName = sc.nextLine();
		System.out.print("도시 특산물 입력 >");
		String localProduct = sc.nextLine();
		System.out.print("도시 명소 입력 >");
		String hotPlace = sc.nextLine();
		try {
			System.out.print("도시 인구수 입력 >");
			cityPopulation = sc.nextLong();
			System.out.print("도시 면적 입력 >");
			cityArea = sc.nextLong();
			System.out.print("소속 입력 >");
			provinceNo = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("인구수/면적/소속 입력은 숫자로 해주세요.");
			return;
		}
		int result = cc.insertCity(new CityDto(cityName, localProduct, hotPlace, cityPopulation, cityArea, provinceNo));
		if(result > 0) {
			System.out.println("도시 생성 성공");
		} else {
			System.out.println("도시 생성 실패");
		}
	}
	
	private void updateCity() {
		selectCities();
		int cityNo;
		String cityName;
		Long cityPopulation;
		String localProduct;
		String hotPlace;
		Long cityArea;
		int provinceNo;
		try {
			System.out.print("수정 도시 ID 입력 >");
			cityNo = sc.nextInt();
			sc.nextLine();
			System.out.println("도시 추가");
			System.out.print("도시 이름 입력 >");		
			cityName = sc.nextLine();
			System.out.print("도시 특산물 입력 >");
			localProduct = sc.nextLine();
			System.out.print("도시 명소 입력 >");
			hotPlace = sc.nextLine();
			System.out.print("도시 인구수 입력 >");
			cityPopulation = sc.nextLong();
			System.out.print("도시 면적 입력 >");
			cityArea = sc.nextLong();
			System.out.print("소속 입력 >");
			provinceNo = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("인구수/면적/소속 입력은 숫자로 해주세요.");
			return;
		}
		int result = cc.updateCity(new CityDto(cityNo, cityName, localProduct, hotPlace, cityPopulation, cityArea, provinceNo));
		if(result > 0) {
			System.out.println("도시 생성 성공");
		} else {
			System.out.println("도시 생성 실패");
		}
		
		
	}
	
	private void deleteCity() {
		selectCities();
		System.out.println(" 도시 삭제");
		System.out.println("[삭제]도시 ID 입력");
		int cityNo;
		try {
		cityNo = sc.nextInt();
		sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("ID를 숫자로 입력해주세요.");
			return;
		}
		int result = cc.deleteCity(cityNo);
		if(result > 0) {
			System.out.println(cityNo + " 삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	
	
	
	
	
	private void provinceMenu() {
		while(true) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("행정구역'도' 정보 관리 시스템");
			System.out.println("1 : 행정구역'도' 추가하기");
			System.out.println("2 : 행정구역'도' 수정하기");
			System.out.println("3 : 행정구역'도' 삭제하기");
			System.out.println("4 : 관리 시스템 종료");
			System.out.println("==========================");
			System.out.print("메뉴를 선택해주세요 >");
			String menuNum = sc.nextLine();
			switch(menuNum) {
			case "1": insertProvince(); break;
			case "2": updateProvince(); break;
			case "3": deleteProvince(); break;
			case "4": return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
	private void selectProvinces() {
		System.out.println("=========================");
		List<ProvinceDto> provinces = pc.selectProvinces();
		if(provinces.isEmpty()) {
			System.out.println("존재하는 '도'가 없습니다.");
		} else {
			provinces.stream()
				     .map(p->"[지역고유번호:"+p.getProvinceNo()
				           +" ,지역이름:"+p.getProvinceName()
				           +" ,지역번호:"+p.getLocalNo() + "]")
				     .forEach(System.out::println);
		}
	}
	
	private void insertProvince() {
		System.out.println(" 행정구역'도' 추가");
		System.out.print("행정 구역의 이름 입력 >");
		String provinceName = sc.nextLine();
		System.out.print("행정 구역의 지역번호 입력 >");
		String localNo = sc.nextLine();
		
		int result = pc.insertProvince(new ProvinceDto(provinceName, localNo));
		if(result > 0) {
			System.out.println(provinceName + " 추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	private void updateProvince() {
		selectProvinces();
		System.out.println(" 행정구역'도' 수정");
		System.out.println("[수정]행정 구역 ID 입력");
		int provinceNo;
		try {
		provinceNo = sc.nextInt();
		sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("ID를 숫자로 입력해주세요.");
			return;
		}
		System.out.print("[수정]행정 구역의 이름 입력 >");
		String provinceName = sc.nextLine();
		System.out.print("[수정]행정 구역의 지역번호 입력 >");
		String localNo = sc.nextLine();
		
		int result = pc.updateProvince(new ProvinceDto(provinceNo, provinceName, localNo));
		if(result > 0) {
			System.out.println(provinceName + " 수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	
	private void deleteProvince() {
		selectProvinces();
		System.out.println(" 행정구역'도' 삭제");
		System.out.println("[삭제]행정 구역 ID 입력");
		int provinceNo;
		try {
		provinceNo = sc.nextInt();
		sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("ID를 숫자로 입력해주세요.");
			return;
		}
		int result = pc.deleteProvince(provinceNo);
		if(result > 0) {
			System.out.println(provinceNo + " 삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
}

