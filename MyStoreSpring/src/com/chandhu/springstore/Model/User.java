package com.chandhu.springstore.Model;


//import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotNull
	@NotEmpty
	@Size(min=3, max=8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Size(min=5, max=25)
	private String fullName;
	@NotEmpty
	@NotNull
	private String Address;
	@NotEmpty
	@NotNull
	private String card;
	private Integer userId;
	public User(){}
	/**
	 * @param username
	 * @param password
	 * @param fullName
	 * @param address
	 * @param card
	 * @param userId
	 */
	public User(String username, String password, String fullName, String address, String card, Integer userId) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.Address = address;
		this.card = card;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullName=" + fullName + ", Address="
				+ Address + ", card=" + card + ", userId=" + userId + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
