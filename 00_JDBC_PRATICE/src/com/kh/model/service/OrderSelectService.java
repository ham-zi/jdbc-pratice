package com.kh.model.service;

import com.kh.model.dao.OrderSelectDao;
import com.kh.model.dto.OracleDto;

public class OrderSelectService {
	private OracleDto oracleDto;
	public OrderSelectService(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}
	
	OrderSelectDao osd = new OrderSelectDao(oracleDto);
}
