package com.bookexchange.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "u_name")
	private String name;
	
	@Column(name = "u_email")
	private String email;
	
	@Column(name = "u_phoneNumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("userId")
	private Set<Bidding> userBidList = new HashSet<Bidding>() ;

	public User() {
		super();
	}

	public User(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Set<Bidding> getUserBidList() {
		return userBidList;
	}

	public void setUserBidList(Set<Bidding> userBidList) {
		this.userBidList = userBidList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	
	
	
}
