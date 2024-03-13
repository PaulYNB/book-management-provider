package com.paul.book.management.provider.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul.book.management.api.entity.Book;
import com.paul.book.management.api.service.IBookService;
import com.paul.book.management.provider.mapper.BookMapper;

@DubboService(version = "1.0.0" 
	,parameters = {"service.auth","true","param.sign","true"}
		)
@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	public void createBook(Book book) {
		System.out.println("book: " + book);
		bookMapper.insertBook(book);
	}
	
	public List<Book> getBooks(String bookId) {
		List<Book> result = null;
		result = bookMapper.selectBooks(bookId);
		System.out.println("books: " + result);
		return result;
	}

	public Book getBook(String bookId) {
		return bookMapper.selectBook(bookId);
	}
	
	public List<Book> getAllBooks() {
		List<Book> result = null;
		result = bookMapper.selectAllBooks();
		System.out.println("books: " + result);
		return result;		
	}
	
	public void updateBook(Book book) {
		bookMapper.updateBook(book);
	}
	
	public void deleteBook(String bookId) {
		bookMapper.deleteBook(bookId);
	}
}
