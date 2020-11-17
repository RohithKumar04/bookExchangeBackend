package com.bookexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookexchange.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
