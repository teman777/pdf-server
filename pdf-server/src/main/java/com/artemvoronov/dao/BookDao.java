package com.artemvoronov.dao;

import com.artemvoronov.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.artemvoronov.HibernateSessionFactoryUtil;
import java.util.List;


public interface BookDao{
  public Book findById(int id);
  public void save(Book book);
  public void update(Book book);
  public void delete(Book book);
  public List<Book> findAll();
}
