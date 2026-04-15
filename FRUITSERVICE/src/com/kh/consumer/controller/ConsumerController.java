package com.kh.consumer.controller;

import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.consumer.model.service.ConsumerService;

public class ConsumerController {

	ConsumerService ms = new ConsumerService();
	
	
	public boolean isConsumerId(String id) {
		return ms.isConsumerId(id);
	}
	
	public int createConsumer(ConsumerDto dto) {
		return ms.createConsumer(dto);
	}
	
	public ConsumerDto login(ConsumerDto dto) {
		return ms.login(dto);
	}


}
