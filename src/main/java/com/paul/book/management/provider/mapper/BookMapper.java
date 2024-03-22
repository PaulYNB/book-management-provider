package com.paul.book.management.provider.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;
import com.paul.book.management.api.entity.Book;

@Mapper
public interface BookMapper {
	int insertBook(Book book) throws DuplicateKeyException;
	Book selectBook(String bookId);
	List<Book> selectBooks(String bookId);
	List<Book> selectAllBooks();
	int updateBook(Book book);
	int deleteBook(String bookId);
}

