package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserCartDetailPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "USER_CART_ID")
	private long userCartId;

	public long getUserCartId() {
		return userCartId;
	}

	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}

	@Column(name = "PRODUCT_ID")
	private long productId;

	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public UserCartDetailPk(long userCartId, long productId) {
		super();
		this.userCartId = userCartId;
		this.productId = productId;
	}
	
	public UserCartDetailPk() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userCartId ^ (userCartId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCartDetailPk other = (UserCartDetailPk) obj;
		if (userCartId != other.userCartId)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

}
