package com.study.spring.mylibraryinfo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.mylibraryinfo.entity.Book;
import com.study.spring.mylibraryinfo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> listBooks = bookService.getAllBooks(); 
            return new ResponseEntity<>(listBooks, HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        try {
            Book book = bookService.getBookByIsbn(isbn); 
            return Objects.nonNull(book) ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/cod/{cod}")
    public ResponseEntity<Book> getBookByCod(@PathVariable Integer cod) {
        try {
            Book book = bookService.getBookByCod(cod); 
            return Objects.nonNull(book) ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{book}")
    public ResponseEntity<String> getBookInfo(@RequestBody Book pathBook) {
        if(Objects.nonNull(pathBook) && (pathBook.getIsbn() != null || pathBook.getCod() != null)) {
            try {
                Book book = pathBook.getIsbn() != null ? bookService.getBookByIsbn(pathBook.getIsbn()) : bookService.getBookByCod(pathBook.getCod());
                return Objects.nonNull(book) ? new ResponseEntity<>(book.toString(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
