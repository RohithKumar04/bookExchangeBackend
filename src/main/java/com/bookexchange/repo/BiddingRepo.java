package com.bookexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookexchange.model.Bidding;

@Repository
public interface BiddingRepo extends JpaRepository<Bidding, Integer> {

}
