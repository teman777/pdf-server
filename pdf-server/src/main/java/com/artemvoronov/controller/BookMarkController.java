package com.artemvoronov.controller;

import java.util.List;
import java.util.ArrayList;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api")
public class BookMarkController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value="/bookmark/{id}", method =RequestMethod.GET)
  public ResponseEntity<BookMark> getBookMark(@PathVariable int id){
    BookMark bookMark = bookService.findBookMarkById(id);
    if(bookMark == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(bookMark);
  }

  @RequestMapping(value="/bookmark", method=RequestMethod.GET)
  public ResponseEntity<List<BookMark>> getBookMarksForBook(@RequestParam int bookId){
    Book book = bookService.findBook(bookId);
    if(book == null){
      return new ResponseEntity("Not found book with given ID.", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok().body(book.getBookmarks());
  }

  @RequestMapping(value="/bookmark", method=RequestMethod.POST)
  public ResponseEntity<String> addBookMark(@RequestBody BookMark bookmark, @RequestParam int bookId){
    Book book = bookService.findBook(bookId);
    if(book == null){
      return new ResponseEntity("Not found book with given ID.", HttpStatus.NOT_FOUND);
    }
    bookmark.setBook(book);
    bookService.saveBookmark(bookmark);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value="/bookmark/{id}", method=RequestMethod.DELETE)
  public ResponseEntity deleteBookMark(@PathVariable int id){
    BookMark bookmark = bookService.findBookMarkById(id);
    if(bookmark == null){
      return new ResponseEntity("Not found bookmark with given ID.", HttpStatus.NOT_FOUND);
    }
    bookService.deleteBookMark(bookmark);
    return ResponseEntity.ok().build();
  }

}
