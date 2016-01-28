package com.chandhu.springstore.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Purchase {
	private Integer purchaseId;
	private Integer purchaseProductId;
	private Integer purchaseTransaction;
    private Integer purchaseProductQty;
    private float purchaseTotal;
    private Timestamp purchaseDate;
	private Integer purchaseUserId;
	
	public Purchase(){}
	
	public Purchase(Integer purchaseId, Integer purchaseProductId, Integer purchaseTransaction,
			Integer purchaseProductQty, float purchaseTotal, Timestamp purchaseDate, Integer purchaseUserId) {
		
		this.purchaseId = purchaseId;
		this.purchaseProductId = purchaseProductId;
		this.purchaseTransaction = purchaseTransaction;
		this.purchaseProductQty = purchaseProductQty;
		this.purchaseTotal = purchaseTotal;
		this.purchaseDate = purchaseDate;
		this.purchaseUserId = purchaseUserId;
	}
	//testing only
	public Purchase(Integer purchaseUserId, Integer purchaseProductId,Integer purchaseTransaction, Integer purchaseProductQty, Integer purchaseProductPrice) {
		
		
		this.purchaseProductId = purchaseProductId;
		this.purchaseTransaction = purchaseTransaction;
		this.purchaseProductQty = purchaseProductQty;
		this.purchaseTotal = purchaseProductQty*purchaseProductPrice;
		this.purchaseDate = new Timestamp(new Date().getTime());
		this.purchaseUserId = purchaseUserId;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseProductId=" + purchaseProductId
				+ ", purchaseTransaction=" + purchaseTransaction + ", purchaseProductQty=" + purchaseProductQty
				+ ", purchaseTotal=" + purchaseTotal + ", purchaseDate=" + purchaseDate + ", purchaseUserId="
				+ purchaseUserId + "]";
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getPurchaseProductId() {
		return purchaseProductId;
	}
	public void setPurchaseProductId(Integer purchaseProductId) {
		this.purchaseProductId = purchaseProductId;
	}
	public Integer getPurchaseTransaction() {
		return purchaseTransaction;
	}
	public void setPurchaseTransaction(Integer purchaseTransaction) {
		this.purchaseTransaction = purchaseTransaction;
	}
	public Integer getPurchaseProductQty() {
		return purchaseProductQty;
	}
	public void setPurchaseProductQty(Integer purchaseProductQty) {
		this.purchaseProductQty = purchaseProductQty;
	}
	public float getPurchaseTotal() {
		return purchaseTotal;
	}
	public void setPurchaseTotal(float purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Integer getPurchaseUserId() {
		return purchaseUserId;
	}
	public void setPurchaseUserId(Integer purchaseUserId) {
		this.purchaseUserId = purchaseUserId;
	}
	

}
