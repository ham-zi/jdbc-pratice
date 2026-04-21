package com.kh.delivery.vo;

import java.util.Objects;

public class Menu {
	
	private final int menuNo;
	private final int restNo;
	private final String menuName;
	private final int price;
	private final String soldOut;
	public Menu(int menuNo, int restNo, String menuName, int price, String soldOut) {
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
	public int getRestNo() {
		return restNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public int getPrice() {
		return price;
	}
	public String getSoldOut() {
		return soldOut;
	}
	@Override
	public int hashCode() {
		return Objects.hash(menuName, menuNo, price, restNo, soldOut);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(menuName, other.menuName) && menuNo == other.menuNo && price == other.price
				&& restNo == other.restNo && Objects.equals(soldOut, other.soldOut);
	}
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", restNo=" + restNo + ", menuName=" + menuName + ", price=" + price
				+ ", soldOut=" + soldOut + "]";
	}
	
	
}
