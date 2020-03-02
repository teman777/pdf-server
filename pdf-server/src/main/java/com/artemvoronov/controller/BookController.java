package com.artemvoronov.controller;

import java.util.List;
import com.artemvoronov.entity.*;
import com.artemvoronov.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api")
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/book", method = RequestMethod.GET)
  public ResponseEntity<List<Book>> getBooks() {
    List<Book> books = bookService.findAllBooks();
    if(books == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(books);
  }

  @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
  public ResponseEntity<Book> getBook(@PathVariable int id) {
    Book book = bookService.findBook(id);
    if(book == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(book);
  }

  @RequestMapping(value = "/book", method = RequestMethod.PATCH)
  public ResponseEntity<Book> patchBook(@RequestParam int id, @RequestParam String name, @RequestParam String author) {
    Book book = bookService.findBook(id);
    if(book == null){
      return ResponseEntity.notFound().build();
    }
    if(name != null){
        book.setName(name);
    }
    if(author != null){
      book.setAuthor(author);
    }
    bookService.updateBook(book);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value="/book",
                 method = RequestMethod.POST)
  public ResponseEntity addBook(@RequestBody Book book){
    bookService.saveBook(book);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value="/book/{id}", method = RequestMethod.DELETE)
  public ResponseEntity deleteBook(@PathVariable int id){
    if(bookService.findBook(id) == null){
      return ResponseEntity.notFound().build();
    }
    bookService.deleteBook(bookService.findBook(id));
    return ResponseEntity.ok().build();
  }


}
