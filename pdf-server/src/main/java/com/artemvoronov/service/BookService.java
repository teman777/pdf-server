package com.artemvoronov.service;

import com.artemvoronov.dao.*;
import com.artemvoronov.entity.Book;

import java.util.List;

public class BookService {
  private BookDao bookDao;

  public BookService(){
    bookDao = new BookDaoImpl();
  }

  public Book findBook(int id){
    return bookDao.findById(id);
  }

  public void saveBook(Book book){
    bookDao.save(book);
  }

  public void deleteBook(Book book){
    bookDao.delete(book);
  }

  public void updateBook(Book book){
    bookDao.update(book);
  }

  public List<Book> findAllBooks(){
    return bookDao.findAll();
  }
}
