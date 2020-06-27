package com.dxc.pojos;

public class Admin {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private int bookQuantity;
	private String bookStatus;
	
	public Admin() {}
	

	public Admin(int bookId, String bookName, String bookAuthor, int bookQuantity, String bookStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookStatus = bookStatus;
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


	public void setbName(String bookName) {
		this.bookName = bookName;
	}


	public String getbookAuthor() {
		return bookAuthor;
	}


	public void setbAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public int getbookQuantity() {
		return bookQuantity;
	}


	public void setbQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}


	public String getbookStatus() {
		return bookStatus;
	}


	public void setbStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
}
