package com.artemvoronov.dao;

import com.artemvoronov.entity.BookMark;
import java.util.List;

public interface BookMarkDao {
  public void save(BookMark bookmark);
  public List<BookMark> findAll();
  public BookMark findById(int id);
  public void update(BookMark bookmark);
  public void delete(BookMark bookmark);
}
