package com.artemvoronov.entity;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="book")
public class Book{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String url;

	@OneToMany(
		cascade = CascadeType.ALL,
		orphanRemoval = true
		)
	@JoinColumn(name="bookId")
	private List<BookMark> bookmarks;
	public Book(String name, String author, String url){
		this.name = name;
		this.author = author;
		this.url = url;
	}

	public Book(){}

	public void setBookmarks(List<BookMark> bookmarks){
		if(bookmarks == null || bookmarks.size() == 0){
			this.bookmarks = null;
		} else {
			this.bookmarks = bookmarks;
		}
	}

	public List<BookMark> getBookmarks(){
		return this.bookmarks;
	}

	public Book(String name, String author){
		this.name = name;
		this.author = author;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public void addBookmark(BookMark bookmark){
		bookmark.setBook(this);
		if(bookmarks == null){
			bookmarks = new ArrayList<>();
		}
		this.bookmarks.add(bookmark);
	}

	public String getName(){
	       return this.name;
	}

	public void setName(String name){
	       this.name = name;
	}
	public void setAuthor(String author){
	       this.author = author;
	}

	public String getAuthor(){
		return this.author;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUrl(){
		return this.url;
	}
}
