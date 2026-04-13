package com.kh.model.dto;

public class OrdersDto {

	private String OrderNo;
	private String checkCardId;
	private String date;
	public OrdersDto(String orderNo, String checkCardId, String date) {
		super();
		OrderNo = orderNo;
		this.checkCardId = checkCardId;
		this.date = date;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getCheckCardId() {
		return checkCardId;
	}
	public void setCheckCardId(String checkCardId) {
		this.checkCardId = checkCardId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public OrdersDto(String checkCardId, String date) {
		super();
		this.checkCardId = checkCardId;
		this.date = date;
	}
	
	
	
}
