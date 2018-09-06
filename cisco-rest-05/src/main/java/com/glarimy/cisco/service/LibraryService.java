package com.glarimy.cisco.service;

import com.glarimy.cisco.api.Library;
import com.glarimy.cisco.api.exception.BookNotFoundException;
import com.glarimy.cisco.api.exception.DuplicateBookException;
import com.glarimy.cisco.api.exception.InvalidBookException;
import com.glarimy.cisco.api.exception.LibraryException;
import com.glarimy.cisco.api.model.Book;
import com.glarimy.cisco.data.BookRepository;
import com.glarimy.cisco.data.InMemoryBookRepository;

public class LibraryService implements Library {
	private BookRepository repo;

	public LibraryService() {
		repo = new InMemoryBookRepository();
	}

	@Override
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (book == null || book.getIsbn() < 0 || book.getTitle() == null || book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		if (repo.read(book.getIsbn()) != null)
			throw new DuplicateBookException();
		repo.create(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		return repo.read(isbn);
	}

}
