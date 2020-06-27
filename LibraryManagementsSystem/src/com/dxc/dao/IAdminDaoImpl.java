package com.dxc.dao;

	import java.sql.*;

	import java.util.*;

	import com.dxc.pojos.Book;
	import com.dxc.pojos.Users;

public class IAdminDaoImpl  implements IAdminDao {
	
	    private static Connection conn;
		
		Scanner sc = new Scanner(System.in);

		public void adminConnect()
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
			
		public boolean invalidDetails(String name, String password)
        {
		   try
			{
             Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery("select name,password from admin");
			 while(rset.next())
			    {
			    if(rset.getString(1).equals(name) && rset.getString(2).equals(password))
				{
				return true;
				 }
				break;
				}
				}
			catch (Exception e) 
				{
				System.out.println("Invalid details Occured!!!");
				e.printStackTrace();
				}
				return false;
				}
					
			   public void addBook(int i, String n, String a, int q)
				{
			try
				{
				PreparedStatement pstmt = conn.prepareStatement("insert into book values(?,?,?,?)");	
                 pstmt.setInt(1,i); 
				 pstmt.setString(2,n); 
				 pstmt.setString(3,a);
				 pstmt.setInt(4,q);
				 pstmt.execute(); 
				 System.out.println("Added book record successfully!! ");
				}
				catch (Exception e) 
				{
				e.printStackTrace();
				}
				}
			   
				public void removeBook(int i)
				{
					try
					{
						
						PreparedStatement pstmt = conn.prepareStatement("delete from book where bookid=?");
						pstmt.setInt(1,i);
						pstmt.execute();	
						System.out.println("Book record removed successfully!!");
						}
					catch(Exception e)
					{
					  e.printStackTrace();
					}
				}
				
		public List<Users> getListOfBooks(String s) 
	      {
			List<Users> list = new ArrayList<>();
				try
					{
	                Statement stmt = conn.createStatement();
					PreparedStatement pstmt = conn.prepareStatement("select username,bookissued from users where username=?");
					pstmt.setString(1, s);
					ResultSet rset = pstmt.executeQuery();
					System.out.println("Username\tBookIssued");
					
						 while(rset.next())
						  {					  
							 list.add(new Users(rset.getString(1),rset.getString(2))); 
						  }
					 }
					catch(SQLException e)
					{
					  e.printStackTrace();
					}
				
					return list;
				}
				
	   public List<Users> getBalance(String s)
		{
			List<Users> list = new ArrayList<>();
				try
				 {
				   Statement stmt = conn.createStatement();
				   PreparedStatement pstmt = conn.prepareStatement("select username,userbalance from users where username=?");
				   pstmt.setString(1, s);
				   ResultSet rset = pstmt.executeQuery();
				   System.out.println("Username\tuserbalance");
				  
					System.out.println("---------------------------");
					while(rset.next())
						  {					  
							 list.add(new Users(rset.getString(1),rset.getInt(2))); 
						  }
					}
				  catch (Exception e) 
					 {
						e.printStackTrace();
					 }
					
				return list;
		}
	 public void deleteAcc(int i)
		 {
			try
			 {
				PreparedStatement pstmt = conn.prepareStatement("delete from users where userid=?");	
                pstmt.setInt(1,i);
				pstmt.execute() ;
				System.out.println("Removed user details successfully!!");
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
		  }
	     catch(Exception e)
		{
		 e.printStackTrace();
		}
	}
}
