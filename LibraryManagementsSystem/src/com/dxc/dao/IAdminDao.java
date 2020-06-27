package com.dxc.dao;

	import java.util.List;

	import com.dxc.pojos.*;

public interface IAdminDao {
	    public void adminConnect();
		public boolean invalidDetails(String u, String p);
		
		public void addBook(int i, String n, String a, int q);
		public void removeBook(int i);
		public List<Users> getListOfBooks(String s);
		public List<Users> getBalance(String s);
		public void deleteAcc(int i);
		public void closeConnection();
}
