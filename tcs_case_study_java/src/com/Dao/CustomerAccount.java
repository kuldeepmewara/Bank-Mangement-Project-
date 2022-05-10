package com.Dao;

import java.sql.Timestamp;

public class CustomerAccount {

	private String name;
	private Timestamp lastUpdated;
	private int customerID;
	
	private String actType;
	private int amount;
	private int AccountID;
	private String status;
	private String message;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	@Override
	public String toString() {
		return "CustomerAccount [name=" + name + ", lastUpdated=" + lastUpdated + ", customerID=" + customerID
				+ ", actType=" + actType + ", amount=" + amount + ", AccountID=" + AccountID + ", status=" + status
				+ ", message=" + message + "]";
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	
}
