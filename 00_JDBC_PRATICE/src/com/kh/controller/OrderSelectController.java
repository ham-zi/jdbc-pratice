package com.kh.controller;

import com.kh.model.dto.OracleDto;
import com.kh.model.service.OrderSelectService;

public class OrderSelectController {

	private OracleDto oracleDto;
	public OrderSelectController(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}
	
	OrderSelectService oss = new OrderSelectService(oracleDto);
}
