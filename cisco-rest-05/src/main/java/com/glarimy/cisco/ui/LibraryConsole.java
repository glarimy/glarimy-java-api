package com.glarimy.cisco.ui;

import com.glarimy.cisco.api.Library;
import com.glarimy.cisco.api.exception.BookNotFoundException;
import com.glarimy.cisco.api.exception.DuplicateBookException;
import com.glarimy.cisco.api.exception.InvalidBookException;
import com.glarimy.cisco.api.exception.LibraryException;
import com.glarimy.cisco.api.model.Book;
import com.glarimy.cisco.service.LibraryService;

public class LibraryConsole {
	public static void main(String[] args) {
		Library library = new LibraryService();
		Book b = library.find(12345);
		System.out.println(b.getTitle());

		Book book = new Book();
		book.setIsbn(1234);
		book.setTitle("First Book");

		library.add(book);

		Book result = library.find(1234);
		System.out.println("Book Found: " + result.getTitle());
	}

}
