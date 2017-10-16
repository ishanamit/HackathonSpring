package com.stackroute.hackathon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   /*the entity instances will be updated or read from the database*/
@Table(name="UserProfile")
public class UserProfile {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="usename")
	private String userName;
	
	@Column(name="emailid")
	private String emailId;
	
	public UserProfile() {}
	
	public UserProfile(int id,String userName,String emailId) {
		this.id=id;
		this.userName=userName;
		this.emailId=emailId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
