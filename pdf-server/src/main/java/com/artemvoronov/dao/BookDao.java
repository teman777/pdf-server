package com.artemvoronov.dao;

import com.artemvoronov.entity.*;
import java.util.List;


public interface BookDao{
  public Book findById(int id);
  public void save(Book book);
  public void update(Book book);
  public void delete(Book book);
  public List<Book> findAll();
  public BookMark findMarkById(int id);
}
