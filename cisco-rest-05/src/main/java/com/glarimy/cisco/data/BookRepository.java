package com.glarimy.cisco.data;

import com.glarimy.cisco.api.model.Book;

public interface BookRepository {
	public int create(Book book);
	public Book read(int isbn);
}
