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
	
	@Override
	public void createBook(Book book) {
		System.out.println("book: " + book);
		bookMapper.insertBook(book);
	}
	
	@Override
	public List<Book> getBooks(String bookId) {
		List<Book> result = null;
		result = bookMapper.selectBooks(bookId);
		System.out.println("books: " + result);
		return result;
	}

	@Override
	public Book getBook(String bookId) {
		return bookMapper.selectBook(bookId);
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> result = null;
		result = bookMapper.selectAllBooks();
		return result;		
	}
	
	@Override
	public void updateBook(Book book) {
		bookMapper.updateBook(book);
	}
	
	@Override
	public void deleteBook(String bookId) {
		bookMapper.deleteBook(bookId);
	}
}
