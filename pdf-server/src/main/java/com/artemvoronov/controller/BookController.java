package com.artemvoronov.controller;

import java.util.List;
import com.artemvoronov.entity.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/book",
                  method = RequestMethod.GET,
                  produces = "application/json")
  public List<Book> getBooks() {
    return bookService.findAllBooks();
  }

  @RequestMapping(value = "/book/{id}",
                  method = RequestMethod.GET,
                  produces = "application/json")
  public Book getBooks(@PathVariable int id) {
    return bookService.findBook(id);
  }
}
