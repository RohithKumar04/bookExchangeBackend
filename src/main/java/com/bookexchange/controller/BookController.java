package com.bookexchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookexchange.model.Book;
import com.bookexchange.model.Response;
import com.bookexchange.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
		
	}
	
	@GetMapping("/{bookId}")
	public Book getBookbyID(@PathVariable("bookId") int bookId) {
		return bookService.getBookById(bookId);
	}
	
	@PostMapping("/")
	public Response addBook(@RequestBody Book bookDetails) {
		Book book = bookService.addBook(bookDetails.getName(),bookDetails.getCategory(),bookDetails.getAuthor(),bookDetails.getEdition());
		
		if(book.getId() > 0) {
			return new Response("Book Added!");
		}
		return new Response("Error :Book not Added!");
		
	}
	
	@PutMapping("/{bookId}")
	public void updateBook() {
		
	}
	
	@DeleteMapping("/{bookId}")
	public Response deleteBook(@PathVariable("bookId") int bookId){
		return bookService.deleteBookById(bookId);
	}

}
