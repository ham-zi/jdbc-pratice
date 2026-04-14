package com.kh.controller;

import java.util.List;

import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;
import com.kh.model.service.OrderSelectService;

public class OrderSelectController {

	private OracleDto oracleDto;
	public OrderSelectController(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}
	
	OrderSelectService oss = new OrderSelectService(oracleDto);
	
	
	public List<ProductDto> selectProduct() {
		return oss.selectProduct();
	}
}
