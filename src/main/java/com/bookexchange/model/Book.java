package com.bookexchange.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "b_name")
	private String name;
	
	@Column(name = "b_category")
	private String category;
	
	@Column(name = "b_author")
	private String author;
	
	@Column(name = "b_edition")
	private float edition;
	
	@OneToOne(mappedBy = "bookId")
	private Bidding bid;
	
	public Book() {
		super();
	}

	public Book(String name, String category, String author, float edition) {
		super();
		this.name = name;
		this.category = category;
		this.author = author;
		this.edition = edition;
	}

	public Bidding getBid() {
		return bid;
	}

	public void setBid(Bidding bid) {
		this.bid = bid;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getEdition() {
		return edition;
	}

	public void setEdition(float edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", author=" + author + ", edition="
				+ edition + "]";
	}
	

	
}
