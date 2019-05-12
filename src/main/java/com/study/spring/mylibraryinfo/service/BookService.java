package com.study.spring.mylibraryinfo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.spring.mylibraryinfo.entity.Book;

@Service
public class BookService {
    private static final List<Book> LIST_OF_BOOKS = Arrays.asList(new Book(1, "God of War", "123-456-784", Book.Genres.FANTASY), 
            new Book(4, "A Bela e a Fera", "851-332-432", Book.Genres.ROMANCE), new Book(3, "Sherlock Holmes", "854-665-842", Book.Genres.DETECTIVE_STORY)); 

    public List<Book> getAllBooks() {
        return LIST_OF_BOOKS;
    }

    public Book getBookByIsbn(String isbn) {
        Optional<Book> optionalBook = LIST_OF_BOOKS.stream().findFirst().filter(book -> book.getIsbn().equals(isbn));
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }

    public Book getBookByCod(Integer cod) {
        Optional<Book> optionalBook = LIST_OF_BOOKS.stream().findFirst().filter(book -> book.getCod().equals(cod));
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }
}
