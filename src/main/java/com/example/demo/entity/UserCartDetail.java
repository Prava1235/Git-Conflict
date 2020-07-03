package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Table(name = "USER_CART_DETAIL")
@Entity
public class UserCartDetail implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@EmbeddedId
	UserCartDetailPk userOrderDetailPk;
	
	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "PRICE")
	private Double price;
	


	public UserCartDetailPk getUserOrderDetailPk() {
		return userOrderDetailPk;
	}




	public void setUserOrderDetailPk(UserCartDetailPk userOrderDetailPk) {
		this.userOrderDetailPk = userOrderDetailPk;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Double getPrice() {
		return price;
	}




	public void setPriceStatus(Double price) {
		this.price = price;
	}




	public UserCartDetail() {

	}




	public UserCartDetail(UserCartDetailPk userOrderDetailPk, int quantity, Double price) {
		super();
		this.userOrderDetailPk = userOrderDetailPk;
		this.quantity = quantity;
		this.price = price;
	}
	
	

}
