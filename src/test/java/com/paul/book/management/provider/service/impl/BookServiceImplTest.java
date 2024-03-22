package com.paul.book.management.provider.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
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
 * 11. Repeat from step #4 to step #10 for other operations on Books. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class BookServiceImplTest {
	
	@Autowired
	IBookService bookService;
	
	private static final String BOOK_ID = "book1";

	@Test
	public void test01CreateBook() {
		Book book = new Book();
		book.setId(BOOK_ID);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
		try {
			bookService.createBook(book);
		} catch (Exception e) {
			assertThrows("Fail to add a book by IBookService.createBook('book1')", 
					DuplicateKeyException.class, 
					() -> {  
						bookService.createBook(book);  
			        });
		}
	}
	
	@Test
	public void test02GetBooks() {
		String bookId = BOOK_ID;
		List<Book> books = bookService.getBooks(bookId);
		assertTrue("No records returned by IBookService.getBooks(bookId), " +
				" please add some books first.", books.size()>0);
	}
	
	@Test
	public void test03GetBook() {
		String bookId = BOOK_ID;
		Book book = bookService.getBook(bookId);
		assertNotNull("No record returned by IBookService.getBook(bookId), " +
				" please check.", book);
	}
	
	@Test
	public void test04GetAllBooks() {
		List<Book> books = bookService.getAllBooks();
		assertTrue("No records returned by IBookService.getAllBooks(), " +
				" please add some books first.", 
				Optional.of(books.get(0)).isPresent());		
	}
	
	@Test
	public void test05UpdateBook() {
		String bookId = BOOK_ID;
		Book book = new Book();
		book.setId(bookId);
		book.setBookName("红楼梦1");
		book.setAuthor("曹雪芹");
		int cnt = bookService.updateBook(book);
		assertTrue("No record updated via booId '" + bookId +
				"', please check test case test05UpdateBook.", cnt==1);
	}	
	
	@Test
	public void test06DeleteBook() {
		String bookId = BOOK_ID;
		int cnt = bookService.deleteBook(bookId);
		assertTrue("No record deleted via booId '" + bookId +
				"', please check test case test06DeleteBook.", cnt==1);
	}
	
}
