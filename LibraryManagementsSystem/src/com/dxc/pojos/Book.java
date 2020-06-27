package com.dxc.pojos;

public class Book {
	private int bookId;
	private String bookName;
	private String  bookAuthor;
	private int bookQuantity;
	
	public Book() {}

	public Book(int bookId, String bookName, String bookAuthor, int bookQuantity) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
	}
	
	public Book(int bookId, String bookName,String bookAuthor) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	

	public int getbookId() {
		return bookId;
	}

	public void setbookId(int bookId) {
		this.bookId = bookId;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public String getbookAuthor() {
		return bookAuthor;
	}

	public void setbookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getbookQuantity() {
		return bookQuantity;
	}

	public void setbookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
	public void display()
	{
		System.out.println(bookId+"  "+bookName+"  "+bookAuthor+"  "+bookQuantity);
	}
	
	public void show()
	{
		System.out.println(bookId+"\t"+bookName+"\t\t"+bookAuthor);
	}
    
	
}
