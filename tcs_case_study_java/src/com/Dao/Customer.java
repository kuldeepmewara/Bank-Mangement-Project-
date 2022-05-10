package com.Dao;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer {
	
	private String name,state,city,status,message,address;
	private Timestamp lastUpdated;
	private int customerSSNID,customerID,age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp t ) {
		this.lastUpdated = t ;
	}
	public int getCustomerSSNID() {
		return customerSSNID;
	}
	public void setCustomerSSNID(int customerSSNID) {
		this.customerSSNID = customerSSNID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", state=" + state + ", city=" + city + ", status=" + status + ", message="
				+ message + ", address=" + address + ", lastUpdated=" + lastUpdated + ", customerSSNID=" + customerSSNID
				+ ", customerID=" + customerID + ", age=" + age + "]";
	}
	
	

}
