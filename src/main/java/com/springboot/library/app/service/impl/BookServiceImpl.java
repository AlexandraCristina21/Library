package com.springboot.library.app.service.impl;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.springboot.library.app.exception.ResourceException;
import com.springboot.library.app.model.Book;
import com.springboot.library.app.repository.BookRepository;
import com.springboot.library.app.service.BookService;



@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository; 

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> listBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void delete(long id) {
		bookRepository.deleteById(id);

	}


	@Override
	public Book update(Book book, long id) {

		Book existing = bookRepository.findById(id).orElseThrow(
				() -> new ResourceException("Book","Id",id));
		existing.setTitle(book.getTitle());
		existing.setAuthor(book.getAuthor());
		bookRepository.save(existing);
		return existing;
	}



}














