package com.kh.model.service;

import com.kh.model.dao.OrderInsertDao;
import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;

public class OrderInsertService {
	
	OrderInsertDao oid;
	public OrderInsertService(OracleDto oracleDto) {
		oid = new OrderInsertDao(oracleDto);
	}
	
	
	
	
	public int insertProduct(ProductDto pdto) {
		System.out.println();
		return oid.insertProduct(pdto);
	}
	
}
