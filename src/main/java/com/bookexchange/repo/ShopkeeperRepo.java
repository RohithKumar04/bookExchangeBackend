package com.bookexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookexchange.model.Shopkeeper;

@Repository
public interface ShopkeeperRepo extends JpaRepository<Shopkeeper, Integer>{

}
