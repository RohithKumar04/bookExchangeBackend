package com.bookexchange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Bidding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bidding_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties("userBidList")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "shopKeeperId")
	@JsonIgnoreProperties("shopBidList")
	private Shopkeeper shopKeeperId;
	
	@OneToOne
	@JoinColumn(name = "bookId")
	@JsonIgnoreProperties("bid")
	private Book bookId;
	
	private int bidAmount;


	public Bidding() {
		super();
	}

	public Bidding(User userId, Shopkeeper shopKeeperId, Book bookId, int bidAmount) {
		super();
		this.userId = userId;
		this.shopKeeperId = shopKeeperId;
		this.bookId = bookId;
		this.bidAmount = bidAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Shopkeeper getShopKeeperId() {
		return shopKeeperId;
	}

	public void setShopKeeperId(Shopkeeper shopKeeperId) {
		this.shopKeeperId = shopKeeperId;
	}	

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public String toString() {
		return "Bidding [id=" + id + ", userId=" + userId + ", shopKeeperId=" + shopKeeperId + ", BookId=" + bookId
				+ ", bidAmount=" + bidAmount + "]";
	}
}
