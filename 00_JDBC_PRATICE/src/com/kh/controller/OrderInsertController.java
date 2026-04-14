package com.kh.controller;

import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;
import com.kh.model.service.OrderInsertService;

public class OrderInsertController {
	OrderInsertService ois;
	public OrderInsertController(OracleDto oracleDto) {
		this.ois = new OrderInsertService(oracleDto);

	}
	

	public int insertProduct(ProductDto pdto) {
		return ois.insertProduct(pdto);
	}
	
}
