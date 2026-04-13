package com.kh.model.dto;

public class ProductDto {
	
	private String productNo;
	private String fruitName;
	private int fruitStock;
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public int getFruitStock() {
		return fruitStock;
	}
	public void setFruitStock(int fruitStock) {
		this.fruitStock = fruitStock;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public ProductDto(String fruitName, int fruitStock, int productPrice) {
		super();
		this.fruitName = fruitName;
		this.fruitStock = fruitStock;
		this.productPrice = productPrice;
	}
	public ProductDto(String productNo, String fruitName, int fruitStock, int productPrice) {
		super();
		this.productNo = productNo;
		this.fruitName = fruitName;
		this.fruitStock = fruitStock;
		this.productPrice = productPrice;
	}
	private int productPrice;


}
