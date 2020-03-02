package com.artemvoronov.service;

import com.artemvoronov.dao.BookMarkDao;
import com.artemvoronov.dao.BookDao;
import com.artemvoronov.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

  @Autowired
  private BookDao bookDao;

  @Autowired
  private BookMarkDao bookMarkDao;

  public void setBookDao(BookDao bookMarkDao){
    this.bookDao = bookDao;
  }

  public BookDao getBookDao(){
    return this.bookDao;
  }

  public void setBookMarkDao(BookMarkDao bookMarkDao){
    this.bookMarkDao = bookMarkDao;
  }

  public BookMarkDao getBookMarkDao(){
    return this.bookMarkDao;
  }

  public BookServiceImpl(){}

  @Override
  public Book findBook(int id){
    return bookDao.findById(id);
  }

  @Override
  public void saveBook(Book book){
    bookDao.save(book);
  }

  @Override
  public void deleteBook(Book book){
    bookDao.delete(book);
  }

  @Override
  public void updateBook(Book book){
    bookDao.update(book);
  }

  @Override
  public BookMark findBookMarkById(int id){
    return bookMarkDao.findById(id);
  }

  @Override
  public void saveBookmark(BookMark bookmark){
    bookMarkDao.save(bookmark);
  }

  @Override
  public List<Book> findAllBooks(){
    return bookDao.findAll();
  }
}
