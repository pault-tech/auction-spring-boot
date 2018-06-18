
package com.paultan.model;



public class Bid {
	
	private String productId;
	
	private User user;
	
	private Double amount;

	public Bid() {
		super();
	}

	public Bid(String productId, User user, Double amount) {
		super();
		this.productId = productId;
		this.user = user;
		this.amount = amount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bid [productid=" + productId + ", user=" + user + ", amount=" + amount + "]";
	}

}
