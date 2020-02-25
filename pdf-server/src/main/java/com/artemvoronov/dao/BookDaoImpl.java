package com.artemvoronov.dao;
import com.artemvoronov.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.artemvoronov.HibernateSessionFactoryUtil;
import java.util.List;


public class BookDaoImpl implements BookDao {
  public Book findById(int id){
    return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id);
  }

  public void save(Book book){
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.save(book);
    tx.commit();
    session.close();
  }
  public void update(Book book){
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.update(book);
    tx.commit();
    session.close();
  }

  public void delete(Book book){
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.delete(book);
    tx.commit();
    session.close();
  }

  public List<Book> findAll(){
    List<Book> books = (List<Book>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Book").list();
    return books;
  }

  public BookMark findMarkById(int id) {
    return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookMark.class, id);
  }



}
