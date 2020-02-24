package com.artemvoronov;
import com.artemvoronov.entity.*;
import com.artemvoronov.service.*;

public class App
{
    public static void main( String[] args )
    {
	BookService bookService = new BookService();
        Book book = new Book("sdf","dsf","/url/url/");
        bookService.saveBook(book);
    }
}
