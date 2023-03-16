package com.springboot.library.app.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.app.model.Book;
import com.springboot.library.app.service.BookService;

@RestController
@RequestMapping("/library/books")
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;

	}


	//http://localhost:8072/library/books
	@PostMapping
	public ResponseEntity<Book> save(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.save(book),HttpStatus.CREATED);
	}

	//http://localhost:8072/library/books
	@GetMapping
	public List<Book> listBooks(){
		return bookService.listBooks();

	};

	//Update
	//http://localhost:8072/library/books/1
	@PutMapping("{id}")
	public ResponseEntity<Book> update(@PathVariable("id")long id, @RequestBody Book book){
		return new ResponseEntity<Book>(bookService.update(book,id), HttpStatus.OK);
	}

	//Delete
	//http://localhost:8072/library/books/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id")long id){
		bookService.delete(id);
		return new ResponseEntity<String>("Book deleted successfully", HttpStatus.OK);
	}


	////find by title
	//////http://localhost:8072/library/books/title?title=aa
	//@Autowired
	//BookRepository repo;
	//@GetMapping("library/books/title")
	//public ResponseEntity<List<Book>> getBookByTitle(@RequestParam String title){
	//	return new ResponseEntity<List<Book>>(repo.findByTitle(title),HttpStatus.OK);
	//}



}



