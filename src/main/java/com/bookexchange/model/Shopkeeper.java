package com.bookexchange.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shopkeeper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "s_name")
	private String shopName;
	
	@Column(name = "s_owner")
	private String ownerName;
	
	@Column(name = "s_mobile")
	private String mobile;
	
	@Column(name = "s_email")
	private String email;
	
	@Column(name = "s_address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shopKeeperId")
	private Set<Bidding> shopBidList = new HashSet<Bidding>();
	

	public Shopkeeper() {
		super();
	}

	public Shopkeeper(String shopName, String ownerName, String mobile, String email, String address) {
		super();
		this.shopName = shopName;
		this.ownerName = ownerName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	
	public Set<Bidding> getShopBidList() {
		return shopBidList;
	}

	public void setShopBidList(Set<Bidding> shopBidList) {
		this.shopBidList = shopBidList;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Shopkepper [id=" + id + ", shopName=" + shopName + ", ownerName=" + ownerName + ", phoneNumber="
				+ mobile + ", email=" + email + ", address=" + address + "]";
	}

}
