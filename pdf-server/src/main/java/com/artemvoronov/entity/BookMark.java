package com.artemvoronov.entity;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="bookmark")
public class BookMark{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int bookId;
	private Date date;


	public BookMark(int bookId, Date date){
		this.bookId = bookId;
		this.date = date;
	}

	public BookMark(){
	}

	public int getId(){
		return this.id;
	}

	public int getBookId(){
		return this.bookId;
	}

	public Date getDate(){
		return date;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}

	public void setDate(Date date){
		this.date = date;
	}

}
