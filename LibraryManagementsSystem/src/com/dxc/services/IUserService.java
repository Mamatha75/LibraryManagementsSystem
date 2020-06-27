package com.dxc.services;

import java.util.List;

import com.dxc.pojos.Book;
public interface IUserService {
	public void userConnect();
	public boolean invalidDetails(String uName,String uPassword);
	public void issueBook();
	public List<Book> getBookList(String s);
	public void getUserBalance(String s);
	public void closeConnection();

}
