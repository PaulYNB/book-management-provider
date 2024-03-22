package com.paul.book.management.provider.service.impl;

import java.util.List;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.paul.book.management.api.entity.Book;
import com.paul.book.management.api.service.IBookService;
import com.paul.book.management.provider.mapper.BookMapper;

@DubboService(version = "1.0.1" 
	,parameters = {"service.auth","true","param.sign","true"}
		)
@Service
public class BookServiceImpl implements IBookService {
	
	private static Logger logger = LogManager.getLogger(BookServiceImpl.class);
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public int createBook(Book book) throws DuplicateKeyException {
		int cnt = 0;
		try {
			cnt = bookMapper.insertBook(book);
		} catch (DuplicateKeyException e) {
			logger.warn("CREATE: " + e.getMessage());
			throw e;
		}
		logger.info("CREATE: The count of records inserted via book: {" 
				+ book + "} is: " + cnt);
		return cnt;
	}
	
	@Override
	public List<Book> getBooks(String bookId) {
		List<Book> result = null;
		result = bookMapper.selectBooks(bookId);
		logger.info("GET: Got books via book id '" + bookId + "': " + result);
		return result;
	}

	@Override
	public Book getBook(String bookId) {
		Book result = bookMapper.selectBook(bookId);
		logger.info("GET: Got one book via book id '" + bookId + "': " + result);
		return result;
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> result = null;
		result = bookMapper.selectAllBooks();
		logger.info("GET: Got all books: " + result);
		return result;		
	}
	
	@Override
	public int updateBook(Book book) {
		int cnt = bookMapper.updateBook(book);
		logger.info("UPDATE: The count of records updated via book: {" 
				+ book + "} is: " + cnt);
		return cnt;
	}
	
	@Override
	public int deleteBook(String bookId) {
		int cnt = bookMapper.deleteBook(bookId);
		logger.info("DELETE: The count of records deleted via bookid '" 
				+ bookId + "': " + cnt);
		return cnt;
	}
}
