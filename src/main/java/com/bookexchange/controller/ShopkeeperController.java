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
import com.bookexchange.model.Response;
import com.bookexchange.model.Shopkeeper;
import com.bookexchange.service.ShopkeeperService;

@RestController
@RequestMapping("/shop")
public class ShopkeeperController {

	@Autowired
	public ShopkeeperService shopkeeperService;
	
	@GetMapping("/")
	public List<Shopkeeper> getAllShopkeepers() {
		return shopkeeperService.getAllShopkeepers();
	}
	
	@GetMapping("/{shopkeeperId}")
	public Shopkeeper getShopkeeperbyID(@PathVariable("shopkeeperId") int shopkeeperId) {
		return shopkeeperService.getShopkeeperById(shopkeeperId);
	}
	
	@PostMapping("/")
	public Response addShopkeeper(@RequestBody Shopkeeper shopDetails) {
		Shopkeeper shopkeeper = shopkeeperService.addShopkeeper(shopDetails.getShopName(),shopDetails.getOwnerName(),shopDetails.getMobile(),shopDetails.getEmail(),shopDetails.getAddress());
		if(shopkeeper.getId() > 0) {
			return new Response("Shopkeeper added Successfully");
		}
		
		return new Response("Error: Shopkeeper not added ");
		
	}
	
	@PutMapping("/{shopkeeperId}")
	public void updateShopkeeper() {
		
	}
	
	@DeleteMapping("/{shopkeeperId}")
	public void deleteShopkeeper(@PathVariable("shopkeeperId") int shopkeeperId){
		shopkeeperService.deleteShopkeeperById(shopkeeperId);
	}
	
	@PostMapping("/{shopkeeperId}/bid")
	public Response bidForBook(@PathVariable("shopkeeperId") int shopkeeperId, @RequestBody Map<String, Object> bidDetails) {
		return shopkeeperService.bidForBook(shopkeeperId, (Integer) bidDetails.get("bidId"), (Integer) bidDetails.get("bidAmount"));
	}
	
	@GetMapping("/{shopkeeperId}/bidStatus")
	public Set<Bidding> biddingStatus(@PathVariable("shopkeeperId") int shopkeeperId) {
		return shopkeeperService.biddingStatus(shopkeeperId);
	}
}
