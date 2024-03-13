package com.paul.book.management.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.paul.book.management.api.entity.Book;

@Mapper
public interface BookMapper {
	void insertBook(Book book);
	Book selectBook(String bookId);
	List<Book> selectBooks(String bookId);
	List<Book> selectAllBooks();
	void updateBook(Book book);
	void deleteBook(String bookId);
}

