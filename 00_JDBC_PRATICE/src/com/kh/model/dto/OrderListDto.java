package com.kh.model.dto;

public class OrderListDto {

	private String orderNo;
	private String productNo;
	public OrderListDto(String orderNo, String productNo) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
	
	
}
