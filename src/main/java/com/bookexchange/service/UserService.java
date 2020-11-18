package com.bookexchange.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookexchange.model.Bidding;
import com.bookexchange.model.Book;
import com.bookexchange.model.Response;
import com.bookexchange.model.User;
import com.bookexchange.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BidService biddingService;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getUserById(int userId) {
		User currentUser = userRepo.findById(userId).get();
		return currentUser;
		
	}
	
	public User addUser(String name, String email, String mobile) {
		
		User u1 = new User(name,email,mobile);
		return userRepo.save(u1);	
	}
	
	public Response deleteUserById(int userId) {
		userRepo.deleteById(userId);		
		return new Response("User deleted Successfully");
		
	}

	public Response requestBook(int userId, Book bookDetails, int bidAmount) {
		Book book = bookService.addBook(bookDetails.getName(),bookDetails.getCategory(),bookDetails.getAuthor(),bookDetails.getEdition());
		User user = userRepo.findById(userId).get();
		biddingService.addUserRequest(user, book.getId(), bidAmount);
		
		return new Response("Request Posted successfully!!");
	}

	public Set<Bidding> getBidStatus(int userId) {
		User currentUser = userRepo.findById(userId).get();
		return currentUser.getUserBidList();
	}

}
