package com.artemvoronov.service;

import com.artemvoronov.dao.*;
import com.artemvoronov.entity.*;
import java.util.List;



public interface BookService {
  public Book findBook(int id);
  public void saveBook(Book book);
  public void saveBookmark(BookMark bookmark);
  public void deleteBook(Book book);
  public void updateBook(Book book);
  public BookMark findBookMarkById(int id);
  public List<Book> findAllBooks();
}
