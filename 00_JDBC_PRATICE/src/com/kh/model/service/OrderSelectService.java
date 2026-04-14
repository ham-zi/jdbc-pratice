package com.kh.model.service;

import java.util.List;

import com.kh.model.dao.OrderSelectDao;
import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;

public class OrderSelectService {
	private OracleDto oracleDto;
	public OrderSelectService(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}
	
	OrderSelectDao osd = new OrderSelectDao(oracleDto);
	
	
	public List<ProductDto> selectProduct() {
		return osd.selectProduct();
	}
}
