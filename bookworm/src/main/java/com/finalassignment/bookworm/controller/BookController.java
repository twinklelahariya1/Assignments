package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private final BookServiceImpl bookService;
    private  final AuthorServiceImpl authorService;
    private final GenreServiceImpl genreService;

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService, GenreServiceImpl genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @PostMapping("/bookworm/addBook/{authorId}/{genreId}")
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto bookDto, @PathVariable Long authorId, @PathVariable Long genreId) {

        AuthorDto authorDto = authorService.findById(authorId);
        GenreDto genreDto = genreService.findById(genreId);

        return new ResponseEntity(bookService.addBook(bookDto), new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookworm/showBookById/{book_id}")
    public BookDto showBookById(@PathVariable Long book_id) {
//        log.debug("Getting Customers By Id.");
        return bookService.findById(book_id);
    }

    @GetMapping("/bookworm/showAllBooks")
    public ResponseEntity<List> showAllBooks() {

        return ResponseEntity.ok(bookService.getBook());

    }

}
