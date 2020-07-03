package com.example.demo.model;

import java.util.List;


public class UserOrderDetailModel {
		
private String orderDate;

private long orderId;

private String orderStatus;

private long userId;
	
private List<OrderDetailModel> orderDetailModelList ;

public List<OrderDetailModel> getOrderDetailModelList() {
	return orderDetailModelList;
}

public void setOrderDetailModelList(List<OrderDetailModel> orderDetailModelList) {
	this.orderDetailModelList = orderDetailModelList;
}

public String getOrderDate() {
	return orderDate;
}

public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}

public long getOrderId() {
	return orderId;
}

public void setOrderId(long orderId) {
	this.orderId = orderId;
}

public String getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}



}
