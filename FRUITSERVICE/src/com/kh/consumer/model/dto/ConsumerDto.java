package com.kh.consumer.model.dto;

import java.sql.Date;

public class ConsumerDto {

	
	private int consumerNo;
	private String consumerId;
	private String consumerPw;
	private Date hireDate;
	public ConsumerDto(int consumerNo, String consumerId, String consumerPw, Date hireDate) {
		super();
		this.consumerNo = consumerNo;
		this.consumerId = consumerId;
		this.consumerPw = consumerPw;
		this.hireDate = hireDate;
	}
	public ConsumerDto(String consumerId, String consumerPw) {
		super();
		this.consumerId = consumerId;
		this.consumerPw = consumerPw;
	}
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerPw() {
		return consumerPw;
	}
	public void setConsumerPw(String consumerPw) {
		this.consumerPw = consumerPw;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}



	
}
