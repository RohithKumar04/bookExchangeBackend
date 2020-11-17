package com.bookexchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookexchange.model.Response;
import com.bookexchange.model.Shopkeeper;
import com.bookexchange.repo.ShopkeeperRepo;

@Service
public class ShopkeeperService {
	
	@Autowired
	private ShopkeeperRepo shopkeeperRepo;
	
	@Autowired
	private BidService bidService;
	
	public List<Shopkeeper> getAllShopkeepers(){
		return shopkeeperRepo.findAll();
	}
	
	public Shopkeeper getShopkeeperById(int shopkeeperId) {
		Shopkeeper currentShopkeeper = shopkeeperRepo.findById(shopkeeperId).get();
		return currentShopkeeper;
		
	}
	
	public Shopkeeper addShopkeeper(String name, String owner, String mobile, String email, String address) {
		Shopkeeper s1 = new Shopkeeper(name, owner, mobile, email, address);
		return shopkeeperRepo.save(s1);
				
	}
	
	public Response deleteShopkeeperById(int shopkeeperId) {
		shopkeeperRepo.deleteById(shopkeeperId);		
		return new Response("Shopkeeper added Successfully");
		
	}

	public Response bidForBook(int shopkeeperId, int bidId, int bidPrice) {
		// TODO Auto-generated method stub
		Shopkeeper shop = shopkeeperRepo.findById(shopkeeperId).get();
		return bidService.bidForBook(shop, bidId, bidPrice);
	}

}
