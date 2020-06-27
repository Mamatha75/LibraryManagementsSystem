package com.dxc.presentation;

	import java.util.*;

	import com.dxc.pojos.Admin;
	import com.dxc.pojos.*;
	import com.dxc.services.*;


public class Test {

		public static void main(String[] args)
		{
			int choice,ch,ch1;
			 
			Scanner sc  = new Scanner(System.in);
			
			IAdminService adminService = new IAdminServiceImpl();
			IUserService  userService = new IUserServiceImpl();
			Users u1 = new Users();
			Book book = new Book();

			adminService.adminConnect(); 

			while(true)
			{
				
				System.out.println("Enter any option:");
				System.out.println("1.Admin");
				System.out.println("2.User");
				System.out.println("3.exit");
				
		switch(choice = sc.nextInt())
		{
	    case 1 : 
					System.out.println("Enter name:");
					String name = sc.next();
					System.out.println("Enter password:");
					String password = sc.next();
					boolean b = adminService.invalidDetails(name, password);
					  if(b)
					     System.out.println("Admin login successfull");
					  else
						 System.out.println("Admin username or password invalid");
						while(b)
							{
							  System.out.println("Enter any option:");
							  System.out.println("--------------");
							  System.out.println("1.Add Books");
							  System.out.println("2.Remove books");
							  System.out.println("3.Get list of books issued by particular user");
							  System.out.println("4.Get balance amount of particular user");
							  System.out.println("5.Close (Delete) user account from library system");
							  System.out.println("6.exit");
					switch(ch=sc.nextInt())
					 {
						case 1:System.out.println("Enter-Bookid,bookname,author,quantity:"); 
							   adminService.addBook(sc.nextInt(),sc.next(), sc.next(), sc.nextInt());
							   System.out.println();
							   break;
						case 2: System.out.println("Enter book id to remove:");
							   adminService.removeBook(sc.nextInt());
							   System.out.println();
							   break;			    
						case 3:
							  System.out.println("Enter username to get details:");
							  List<Users> list= adminService.getListOfBooks(sc.next());
								  for(Users u:list)
									{
									  u.display();
									  }
									  System.out.println();
									 break;		    
											     
					    case 4 :
								System.out.println("Enter username to get balance:");
								List<Users> l = adminService.getBalance(sc.next());
							        for(Users u:l)
									   {
									     u.show();
										 }
									    System.out.println();
									     break;
					   case 5 : System.out.println("Enter userid to delete account:");
								  adminService.deleteAcc(sc.nextInt());
								  System.out.println();
								  break;
											  
					  case 6 : adminService.closeConnection();
								System.out.println("Connection disconnected");
								System.exit(0);
								}
							}
						break;
							
	  case 2:  userService.userConnect();
			   System.out.println("Enter username:");
			   String uName = sc.next();
			   System.out.println("Enter password:");
			   String uPassword = sc.next();
			   boolean b1 = userService.invalidDetails(uName,uPassword);
			      if(b1)
					 System.out.println("User login successfull!!");
				  else
					 System.out.println("user username or password invalid");
						while(b1)
						  {
						    System.out.println("Enter option:");
							System.out.println("--------------");
							System.out.println("1.Issue books from library");
							System.out.println("2.Get list of books by particular author");
							System.out.println("3.Check available balance in library account");
							System.out.println("4.Terminate");
									
                            switch(ch1=sc.nextInt())
							    {
								   case 1 :
								           userService.issueBook();
										   System.out.println();
										   break;
											       
								   case 2:  System.out.println("Enter book author name:");
										   List<Book> l1 = userService.getBookList(sc.next());
										    for(Book bo:l1)
										  	  {
										  		 bo.show();
										  		}
										  	 System.out.println();
										  	 break;
										  		   
								    case 3: System.out.println("Enter username to get balance:");
										  	userService.getUserBalance(sc.next());
										  	System.out.println();
										  	break;
										  			
									case 4 : userService.closeConnection();
										     System.out.println("Connection disconnected");
										     System.exit(0);									  
										}
                             }
								
					default: System.out.println("Choose correct option");
					break;
			case 3:
				System.out.println("choose correct option");
	            }
		
			}
		}
	}

	
	
		
