package com.kh.delivery.vo;

import java.sql.Date;
import java.util.Objects;

public class Orders {

	private final Long orderNo;
	private final Long memberNo;
	private final int menuNo;
	private final int quantity;
	private final Date orderDate;
	private final String status;


	public Orders(Long orderNo, Long memberNo, int menuNo, int quantity, Date orderDate, String status) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.menuNo = menuNo;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.status = status;
	}


	public Long getOrderNo() {
		return orderNo;
	}


	public Long getMemberNo() {
		return memberNo;
	}


	public int getMenuNo() {
		return menuNo;
	}


	public int getQuantity() {
		return quantity;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public String getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(memberNo, menuNo, orderDate, orderNo, quantity, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(memberNo, other.memberNo) && menuNo == other.menuNo
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(orderNo, other.orderNo)
				&& quantity == other.quantity && Objects.equals(status, other.status);
	}


	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", memberNo=" + memberNo + ", menuNo=" + menuNo + ", quantity=" + quantity
				+ ", orderDate=" + orderDate + ", status=" + status + "]";
	}


	
}
