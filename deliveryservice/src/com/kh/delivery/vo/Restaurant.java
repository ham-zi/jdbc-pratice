package com.kh.delivery.vo;

import java.util.Objects;

public class Restaurant {

	private final int restNo;
	private final String restName;
	private final String category;
	private final int minPrice;
	private final int deliveryFee;
	
	public Restaurant(int restNo, String restName, String category, int minPrice, int deliveryFee) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.category = category;
		this.minPrice = minPrice;
		this.deliveryFee = deliveryFee;
	}
	public int getRestNo() {
		return restNo;
	}
	public String getRestName() {
		return restName;
	}
	public String getCategory() {
		return category;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public int getDeliveryFee() {
		return deliveryFee;
	}
	@Override
	public String toString() {
		return "Restaurant [restNo=" + restNo + ", restName=" + restName + ", category=" + category + ", minPrice="
				+ minPrice + ", deliveryFee=" + deliveryFee + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, deliveryFee, minPrice, restName, restNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(category, other.category) && deliveryFee == other.deliveryFee
				&& minPrice == other.minPrice && Objects.equals(restName, other.restName)
				&& Objects.equals(restNo, other.restNo);
	}
	
	
	
}
