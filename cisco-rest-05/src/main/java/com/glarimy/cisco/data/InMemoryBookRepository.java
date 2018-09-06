package com.glarimy.cisco.data;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.cisco.api.model.Book;

public class InMemoryBookRepository implements BookRepository {
	private Map<Integer, Book> books;

	public InMemoryBookRepository() {
		books = new HashMap<>();
	}

	@Override
	public int create(Book book) {
		books.put(book.getIsbn(), book);
		return book.getIsbn();
	}

	@Override
	public Book read(int isbn) {
		return books.get(isbn);
	}

}
