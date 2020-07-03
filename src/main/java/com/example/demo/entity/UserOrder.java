package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "USER_ORDER")
@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getUserCartId() {
		return userCartId;
	}

	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}

	@Column(name = "USER_CART_ID")
	private long userCartId;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	


	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	public UserOrder(long orderId, long userId, Date orderDate, long userCartId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.userCartId = userCartId;
		this.orderStatus = orderStatus;
	}

	public UserOrder() {

	}

}
