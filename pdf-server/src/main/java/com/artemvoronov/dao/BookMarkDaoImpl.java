package com.artemvoronov.dao;

import java.util.List;
import com.artemvoronov.entity.BookMark;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;

@Repository
public class BookMarkDaoImpl implements BookMarkDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void save(BookMark bookmark){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(bookmark);
    tx.commit();
    session.close();
  }

  @Override
  public List<BookMark> findAll(){
    Session session = sessionFactory.openSession();
    List<BookMark> bookmarks = session.createQuery("From BookMark").list();
    session.close();
    return bookmarks;
  }

  @Override
  public BookMark findById(int id){
    Session session = sessionFactory.openSession();
    BookMark bookmark = session.get(BookMark.class, id);
    session.close();
    return bookmark;
  }

  @Override
  public void update(BookMark bookmark){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.update(bookmark);
    tx.commit();
    session.close();
  }

  @Override
  public void delete(BookMark bookmark){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.delete(bookmark);
    tx.commit();
    session.close();
  }

  public void setSessionFactory(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
  }
}
