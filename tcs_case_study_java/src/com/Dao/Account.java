package com.Dao;

import java.sql.Timestamp;

public class Account {

	private int CustomerId;
	private String actType;
	private int amount;
	private int AccountID;
	private String status;
	private String message;
	private Timestamp lastUpdated;
	
	
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	@Override
	public String toString() {
		return "Account [CustomerId=" + CustomerId + ", actType=" + actType + ", amount=" + amount + ", AccountID="
				+ AccountID + ", status=" + status + ", message=" + message + ", lastUpdated=" + lastUpdated + "]";
	}
	
	
	
	
}
