package com.study.spring.mylibraryinfo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.spring.mylibraryinfo.entity.Book;
import com.study.spring.mylibraryinfo.service.BookService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BookService.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void ThereIsBook() {
        List<Book> listResult = bookService.getAllBooks();

        assertThat(listResult).isNotEmpty();
    }

    @Test
    public void findBookByCode() {
        Integer code = 1;
        Book book = bookService.getBookByCod(code);

        assertNotNull(book);
        assertThat(book).hasNoNullFieldsOrProperties();
    }

    @Test
    public void findBookByIsbn() {
        String isbn = "123-456-784";
        Book book = bookService.getBookByIsbn(isbn);

        assertNotNull(book);
        assertThat(book).hasNoNullFieldsOrProperties();
    }
}
