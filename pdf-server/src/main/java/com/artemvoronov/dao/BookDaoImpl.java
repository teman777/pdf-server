package com.artemvoronov.dao;

import com.artemvoronov.entity.Book;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;

@Repository
public class BookDaoImpl implements BookDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Book findById(int id){
    Session session = sessionFactory.openSession();
    Book book = session.get(Book.class, id);
    session.close();
    return book;
  }
  @Override
  public void save(Book book){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(book);
    tx.commit();
    session.close();
  }
  @Override
  public void update(Book book){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.update(book);
    tx.commit();
    session.close();
  }
  @Override
  public void delete(Book book){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.delete(book);
    tx.commit();
    session.close();
  }
  @Override
  public List<Book> findAll(){
    Session session = sessionFactory.openSession();
    List<Book> books = (List<Book>) session.createQuery("From Book").list();
    session.close();
    return books;
  }


  public void setSessionFactory(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
  }



}
