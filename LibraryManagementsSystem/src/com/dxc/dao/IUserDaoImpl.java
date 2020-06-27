package com.dxc.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Book;
import com.dxc.pojos.Users;
public class IUserDaoImpl implements IUserDao{

	private static Connection conn;
	Scanner sc = new Scanner(System.in);


		public void userConnect()
		{
			try                 
			  {
			  Class.forName("com.mysql.jdbc.Driver");
			  System.out.println("Driver loaded...");
			  
			  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamatha","root","Root");
			  System.out.println("Connected to database...");
			  }
			  catch(Exception e)
				{
				  e.printStackTrace();
				}		
		}
		
		public boolean invalidDetails(String uName,String uPassword)
		  {
			int flag = 0;
			  try
				{
		           Statement stmt = conn.createStatement();
				   ResultSet rset = stmt.executeQuery("select username,password from users");
				 while(rset.next())
					   {
						if(rset.getString(1).equals(uName) && rset.getString(2).equals(uPassword))
						{
							flag=1;
							return true;
							 }
						
						 }
						 if(flag==0)
							 return false;
					 }
					catch (Exception e) 
					{
						System.out.println("Authentication Error Occured!!!");
					}
					return false;
				}
				
	   public void issueBook()
		  {
			try
			  {
		       Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select * from book");
			    System.out.println("Bookid\tBookname\tAuthor\tQuantity");
				System.out.println("---------------------------------------");						  
				while(rset.next())
				    {
					 System.out.println(rset.getInt(1)+"\t"+rset.getString(2)+"\t\t"+rset.getString(3)+"\t "+rset.getInt(4));
						  	}	
						  	System.out.println();
						    System.out.println("Enter bookname to issue:");
						    String s = sc.next();
						    System.out.println("How many books needed:");
						    int n = sc.nextInt();
						    PreparedStatement pstmt = conn.prepareStatement("update book set quantity=quantity-? where bookname=?");
						    pstmt.setInt(1,n);
						    pstmt.setString(2,s);
                            pstmt.execute();
						    System.out.println("How many days you want:");
						    int days = sc.nextInt();
						    
						    PreparedStatement pstmt1 = conn.prepareStatement("update users set userbalance=userbalance-(?*5) where bookissued=?");
						    pstmt1.setInt(1,days);
						    pstmt1.setString(2,s);
						    pstmt1.execute();
						    System.out.println("Book issued successfully!!");
						    
						    
						    }
					 catch (SQLException e) 
					 {
						e.printStackTrace();
					}
					
				}
				
	    public List<Book> getBookList(String s)
		  {
		List<Book> list = new ArrayList<>();
		  try
			{
			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement("select bookid,bookname,author from book where author=?");
			pstmt.setString(1,s);
			ResultSet rset = pstmt.executeQuery();
			System.out.println("Bookid\tBookname\tAuthor");
			System.out.println("---------------------------------");
				while(rset.next())
				 {
					list.add(new Book(rset.getInt(1), rset.getString(2),rset.getString(3)));
					}
				 }
					catch(Exception e)
					{
					  e.printStackTrace();
					}
				return list;
					}
		  public void getUserBalance(String s)
	       {
			 try
				{
				 Statement stmt = conn.createStatement();
				 PreparedStatement pstmt = conn.prepareStatement("select userbalance from users where username=?");
				 pstmt.setString(1,s);
				 ResultSet rset = pstmt.executeQuery();
			       while(rset.next())
				      {
						System.out.println(rset.getInt(1));
					}
						  
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
		public void closeConnection()
		 {
		   try
		    {
			 conn.close();
			}catch (Exception e) 
				   {
					e.printStackTrace();
					}
	     }
}
