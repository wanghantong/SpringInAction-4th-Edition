package org.bookstore.learn.spring.chapter11.repository;

import java.util.Date;
import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Book;
import org.bookstore.learn.spring.chapter11.hibernate.repository.BookRepository;
import org.bookstore.learn.spring.chapter11.hibernate.repository.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class BookRepositoryImplTest {
	@Autowired
	BookRepository BookRepositoryImpl;

	@Test
	@Transactional
	public void findAll() {
		List<Book> list = BookRepositoryImpl.findAll();
		System.out.println("list.size()  " + list.size());
		for (Book ar : list) {
			System.out.println(ar);
		}
	}
	@Test
	@Transactional
	public void save() {
		Book book = new Book();
		book.setAuthor("author");
		book.setAuthor_intro("author_intro");
		book.setBinding("精装");
		book.setCatalog("catalog");
		book.setImage("https://img3.doubanio.com/spic/s1747553.jpg");
		book.setIsbn("1220562");
		book.setLargeImage("https://img3.doubanio.com/spic/s1747553.jpg");
		book.setMediumImage("https://img3.doubanio.com/spic/s1747553.jpg");
		book.setName("测试书籍");
		book.setOrigin_title("test book");
		book.setPages((short)678);
		book.setPrice(67.99);
		book.setPubDate(new Date());
		book.setSecondPrice(30.00);
		book.setSmallImage("https://img3.doubanio.com/spic/s1747553.jpg");
		book.setSummay("summary");
		book.setTranslater("dragon");
		book.getCategory().add("Java");
		book.getCategory().add("spring");
		BookRepositoryImpl.saveBook(book);
	}

}
