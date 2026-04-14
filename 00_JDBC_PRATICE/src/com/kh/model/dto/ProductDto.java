package com.kh.model.dto;

public class ProductDto {
	
	private String productNo;
	private String fruitName;
	private String fruitStock;
	private String fruitPrice;
	public ProductDto(String productNo, String fruitName, String fruitStock, String fruitPrice) {
		super();
		this.productNo = productNo;
		this.fruitName = fruitName;
		this.fruitStock = fruitStock;
		this.fruitPrice = fruitPrice;
	}
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
	public String getFruitStock() {
		return fruitStock;
	}
	public void setFruitStock(String fruitStock) {
		this.fruitStock = fruitStock;
	}
	public String getFruitPrice() {
		return fruitPrice;
	}
	public void setFruitPrice(String fruitPrice) {
		this.fruitPrice = fruitPrice;
	}
	public ProductDto(String fruitName, String fruitStock, String fruitPrice) {
		super();
		this.fruitName = fruitName;
		this.fruitStock = fruitStock;
		this.fruitPrice = fruitPrice;
	}
	
}