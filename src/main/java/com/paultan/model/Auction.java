package com.paultan.model;

import java.util.Date;
import java.util.List;
import java.util.Set;


public class Auction {
	
	private String id;
	
	private Product product;
	
	private Date startTime;
	
	private Date endTime;
	
	private Double startingAmount;
	
	private List<Bid> bids;

	public Auction() {
		super();
	}
	
	public Auction(String id, Product product, Date startTime, Date endTime, Double startingAmount,
			List<Bid> bids) {
		super();
		this.id = id;
		this.product = product;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startingAmount = startingAmount;
		this.setBids(bids);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(Double startingAmount) {
		this.startingAmount = startingAmount;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", product=" + product + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", startingAmount=" + startingAmount + ", bids=" + bids
				+ "]";
	}
	
	
}
