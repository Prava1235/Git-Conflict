package com.example.demo.model;

public class UserOrderModel {
	private long userId;	
	private long userCartId;
	private String status;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserCartId() {
		return userCartId;
	}
	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public UserOrderModel(long userId, long userCartId, String status) {
		super();
		this.userId = userId;
		this.userCartId = userCartId;
		this.status = status;
	}
	public UserOrderModel() {
		
	}
	

	
}
