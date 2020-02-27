package com.artemvoronov;
import com.artemvoronov.entity.*;
import com.artemvoronov.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class App
{
  @Autowired
  private BookService bookService;

    public  void notMain()
    {
      Book book = new Book("sdf","dsf","/url/url/");
      book.addBookMark(new BookMark());
      bookService.saveBook(book);
    }
}
