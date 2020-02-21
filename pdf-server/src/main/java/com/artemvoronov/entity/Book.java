package com.artemvoronov.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="book")
public class Book{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String author;
	private String url;

	@OneToMany(mappedBy="book")
	private Set<BookMark> bookmarks;
	public Book(String name, String author, String url){
		this.name = name;
		this.author = author;
		this.url = url;
	}

	public Book(){}

	public Book(String name, String author){
		this.name = name;
		this.author = author;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getName(){
	       return this.name;
	}

	public String getAuthor(){
		return this.author;
	}

	public int getId(){
		return this.id;
	}

	public String getUrl(){
		return this.url;
	}
}
