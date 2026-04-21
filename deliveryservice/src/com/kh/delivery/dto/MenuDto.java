package com.kh.delivery.dto;

public class MenuDto {
	
	private int menuNo;
	private int restNo;
	private String menuName;
	private int price;
	private String soldOut;
	
	public MenuDto() {
		super();
	}
	
	public MenuDto(int restNo, String menuName, int price, String soldOut) {
		super();
		this.restNo = restNo;
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}

	public MenuDto(int menuNo, int restNo, String menuName, int price, String soldOut) {
		super();
		this.menuNo = menuNo;
		this.restNo = restNo;
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSoldOut() {
		return soldOut;
	}

	public void setSoldOut(String soldOut) {
		this.soldOut = soldOut;
	}
	
	
	

}
