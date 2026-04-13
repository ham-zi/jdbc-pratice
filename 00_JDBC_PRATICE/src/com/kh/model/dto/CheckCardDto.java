package com.kh.model.dto;

public class CheckCardDto {
	
	private String CardId;
	private String back;
	private long account;
	private String cardNumber;
	private int consumerNumber;
	public CheckCardDto(String cardId, String back, long account, String cardNumber, int consumerNumber) {
		super();
		CardId = cardId;
		this.back = back;
		this.account = account;
		this.cardNumber = cardNumber;
		this.consumerNumber = consumerNumber;
	}
	
	
	public CheckCardDto(String back, long account, String cardNumber, int consumerNumber) {
		super();
		this.back = back;
		this.account = account;
		this.cardNumber = cardNumber;
		this.consumerNumber = consumerNumber;
	}


	public String getCardId() {
		return CardId;
	}
	public void setCardId(String cardId) {
		CardId = cardId;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	
	
	
}
