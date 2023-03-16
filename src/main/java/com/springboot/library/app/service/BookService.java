package com.springboot.library.app.service;

import java.util.List;
import java.util.Optional;

import com.springboot.library.app.model.Book;

public interface BookService {
	Book save(Book book);
	List<Book> listBooks();
	Book update(Book book,long id);
	void delete(long id);



}
