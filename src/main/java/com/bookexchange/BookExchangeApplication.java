package com.bookexchange;

import java.util.Currency;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookexchange.model.Bidding;
import com.bookexchange.repo.BookRepo;
import com.bookexchange.repo.UserRepo;
import com.bookexchange.service.BidService;
import com.bookexchange.service.BookService;
import com.bookexchange.service.ShopkeeperService;
import com.bookexchange.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookExchangeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookExchangeApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BidService biddingService;
	
	@Autowired
	private ShopkeeperService shopkeeperService;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
	}

}
