package com.artemvoronov.controller;

import java.util.List;
import com.artemvoronov.entity.*;
import com.artemvoronov.service.BookService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/book",
                  method = RequestMethod.GET)
  public List<Book> getBooks() {
    return bookService.findAllBooks();
  }

  @RequestMapping(value = "/book/{id}",
                  method = RequestMethod.GET
                  )
  public Book getBooks(@PathVariable int id) {
    return bookService.findBook(id);
  }

  @RequestMapping(value="/book",
                 method = RequestMethod.POST)
  public ResponseEntity addBook(@RequestBody Book book){
    bookService.saveBook(book);
    return ResponseEntity.ok().build();
  }


}
