package com.example.demo.model;

public class OrderDetailModel {
	
	private long productid;
	private long quantity;
	private double price;
	public long getProductid() {
		return productid;
	}
	public void setProductid(long orderid) {
		this.productid = orderid;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
