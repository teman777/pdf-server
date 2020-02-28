package com.artemvoronov.controller;

import java.util.List;
import com.artemvoronov.entity.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping("/book", produces = "application/json")
  public List<Book> getBooks() {
    return bookService.findAllBooks();
  }
}
