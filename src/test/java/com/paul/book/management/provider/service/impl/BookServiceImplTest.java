package com.paul.book.management.provider.service.impl;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paul.book.management.api.entity.Book;
import com.paul.book.management.api.service.IBookService;

/*
 * TDD steps:
 * 1. Create interface IBookService.
 * 2. Create class BookServiceImpl to implement IBookService.
 * 3. Create interface BookMapper
 * 4. Create a method IBookService.createBook(Book book)
 * 5. Create a override method BookServiceImpl.createBook(Book book)
 * 6. Create a method BookMapper.insertBook(Book book)
 * 7. Make method BookServiceImpl.createBook(Book book) invoke BookMapper.insertBook(Book book) 
 * 8. Create test case test01CreateBook() to test IBookService.createBook(Book book)
 * 9. Execute test case test01CreateBook(), it fails.
 * 10. Edit com/paul/book/management/provider/mapper/BookMapper.xml until test01CreateBook() runs successfully.
 * 11. Repeat from step #4 to step #10 for other operations. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = ProviderBootApplicationTest.class)
public class BookServiceImplTest {
	
	@Autowired
	IBookService bookService;

	@Test
	public void test01CreateBook() {
		Book book = new Book();
		book.setId("book1");
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
		bookService.createBook(book);
	}
	
	@Test
	public void test02GetBooks() {
		List<Book> books = bookService.getBooks("book1");
		for(Book book: books) {
			System.out.println("getBooks() matches book: " + book + "\n");
		}
	}
	
	@Test
	public void test03GetBook() {
		Book book = bookService.getBook("book1");
		System.out.println("getBook() matches book: " + book);
	}
	
	@Test
	public void test04GetAllBooks() {
		List<Book> books = bookService.getAllBooks();
		for(Book book: books) {
			System.out.println("getAllBooks() matches book: " + book + "\n");
		}		
	}
	
	@Test
	public void test05UpdateBook() {
		Book book = bookService.getBook("book1");
		System.out.println("Book to be updated: " + book);
		book.setBookName("红楼梦1");
		book.setAuthor("曹雪芹");
		bookService.updateBook(book);
		System.out.println("Book updated: " + book);
	}	
	
	@Test
	public void test06DeleteBook() {
		bookService.deleteBook("book1");
	}
	
}
