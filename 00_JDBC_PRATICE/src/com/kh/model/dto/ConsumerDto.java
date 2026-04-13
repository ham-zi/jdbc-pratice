package com.kh.model.dto;

public class ConsumerDto {
	private String consumerNo;
	private String consumerId;
	private String consumerPw;
	public ConsumerDto(String consumerNo, String consumerId, String consumerPw) {
		super();
		this.consumerNo = consumerNo;
		this.consumerId = consumerId;
		this.consumerPw = consumerPw;
	}
	public ConsumerDto(String consumerId, String consumerPw) {
		super();
		this.consumerId = consumerId;
		this.consumerPw = consumerPw;
	}
	public String getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(String consumerNo) {
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
	
	
	

}
