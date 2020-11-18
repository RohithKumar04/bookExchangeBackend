package com.bookexchange.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookexchange.model.Bidding;
import com.bookexchange.model.Book;
import com.bookexchange.model.Response;
import com.bookexchange.model.User;
import com.bookexchange.repo.UserRepo;
import com.bookexchange.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
		
	}
	
	@GetMapping("/{userId}")
	public User getUserbyID(@PathVariable("userId") int userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/")
	public Response addUser(@RequestBody User userDetails) {

		User user = userService.addUser(userDetails.getName(),userDetails.getEmail(),userDetails.getPhoneNumber());
		if(user.getId() > 0) {
			return new Response("User added Successfully");
		}		
		return new Response("Error: User not added ");		
	}
	
	@PutMapping("/{userId}")
	public void updateUser() {
		
	}
	
	@DeleteMapping("/{userId}")
	public Response deleteUser(@PathVariable("userId") int userId){
		return userService.deleteUserById(userId);
	}
	
	@PostMapping("/{userId}/request")
	public Response requestBook(@PathVariable("userId") int userId, @RequestBody Book bookDetails, @RequestParam("bidAmount") int bidAmount) {
		System.out.println(bidAmount);
		return userService.requestBook(userId, bookDetails, bidAmount);
		
	}
	
	@GetMapping("/{userId}/bidStatus")
	public Set<Bidding> bidStatus(@PathVariable("userId") int userId){
		return userService.getBidStatus(userId);
	}

}
