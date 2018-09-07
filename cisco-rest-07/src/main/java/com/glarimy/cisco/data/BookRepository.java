package com.glarimy.cisco.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.cisco.api.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	public List<Book> findByTitle(String title);
}
