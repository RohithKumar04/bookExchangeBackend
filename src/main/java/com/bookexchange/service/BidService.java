package com.bookexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bookexchange.model.Bidding;
import com.bookexchange.model.Book;
import com.bookexchange.model.Response;
import com.bookexchange.model.Shopkeeper;
import com.bookexchange.model.User;
import com.bookexchange.repo.BiddingRepo;

@Service
public class BidService{
	
	@Autowired
	private BiddingRepo biddingRepo;
	
	@Autowired
	private BookService bookService;
	
	public Bidding getBidById(int bidId) {
		return biddingRepo.findById(1).get();
	}
	
	
	//////////////////////////// USER METHODS
	
	public Bidding addUserRequest(User user, int bookId) {
		Book currentBook = bookService.getBookById(bookId);
		
		Bidding bid = new Bidding();
		bid.setBookId(currentBook);
		bid.setUserId(user);
		bid.setBidAmount(100);
		user.getUserBidList().add(bid);
		
		currentBook.setBid(bid);
		System.out.println(bid.hashCode());
		
		return biddingRepo.save(bid);
	}
	
	public Response removeBid(int userId, int bidId) {
		
		Bidding currentBid = biddingRepo.findById(bidId).get();
		
		return new Response("Bid removed Successfully!!");
	}
	
	
	//////////////////////////////////// SHOPKEEPER METHODS
	
	public Response bidForBook(Shopkeeper shopkeeper, int bidId, int bidPrice) {
		
		Bidding currentBid = biddingRepo.findById(bidId).get();

		System.out.println(currentBid.hashCode());
		currentBid.setShopKeeperId(shopkeeper);
		currentBid.setBidAmount(bidPrice);
		
		biddingRepo.save(currentBid);
		shopkeeper.getShopBidList().add(currentBid);
		
		return new Response("Bidded successfully!!");
	}


}
