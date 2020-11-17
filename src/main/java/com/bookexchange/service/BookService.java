package com.bookexchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookexchange.model.Response;
import com.bookexchange.model.Book;
import com.bookexchange.repo.BookRepo;
import com.bookexchange.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int bookId) {
		Book currentBook = bookRepo.findById(bookId).get();
		return currentBook;
		
	}
	
	public Book addBook(String name, String category, String author, float edition) {
		Book b1 = new Book(name,category, author, edition);
		return bookRepo.save(b1);
		
	}
	
	public Response deleteBookById(int bookId) {
		bookRepo.deleteById(bookId);		
		return new Response("Book added Successfully");
		
	}

	
}
