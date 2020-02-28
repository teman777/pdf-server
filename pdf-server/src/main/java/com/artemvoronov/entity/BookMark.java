package com.artemvoronov.entity;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="bookmark")
public class BookMark{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date createdDate;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="bookId")
	private Book book;

	public BookMark(Date date, Book book){
		this.createdDate = date;
		this.book = book;
	}

	public BookMark(){
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}


	public Book getBook(){
		return book;
	}

	public void setBook(Book book){
		this.book = book;
	}
	public Date getCreatedDate(){
		return createdDate;
	}



	public void setCreatedDate(Date date){
		this.createdDate = date;
	}

}
