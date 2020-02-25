package cg.com.UserManagement.ui;

import java.io.*;
import cg.com.UserManagement.bean.User;
import cg.com.UserManagement.controller.UserController;
import cg.com.UserManagement.dao.UtilityClass;

public class Execute 
{
   private User user = null;
   private BufferedReader br;
   private UserController controller;
   UtilityClass utilityClass = new UtilityClass();
   
   public Execute() 
   {
	   super();
	   br = new BufferedReader(new InputStreamReader(System.in));
	   controller = new UserController();
   }
   public void run() throws IOException
   {
	   int i = 0;
	   String username;
	   String password;
	   while(i!=4)
	   {
		   utilityClass.ShowMessage("User Management System \n" + "1.Login\n" + "2.Register\n" + "3.Logout\n" + "4.Exit\n"+ "Enter your choice:-", 1);
		   int choice = Integer.parseInt(br.readLine());
		   switch(choice)
		   {
		     case 1: utilityClass.ShowMessage("Enter your User Id:-",1);
		             username = br.readLine();
		             utilityClass.ShowMessage("Enter your password:-",1);
		             password = br.readLine();
		             user = controller.login(username, password);
		             if(user!=null)
		             {
		            	 utilityClass.ShowMessage("Logged in successfully!:-",1);
		            	 System.out.println(user);
		            	 user.setLoggedIn(true);
		             }
		             break;
		     case 2: user = getUserDetails();
		                    if(controller.register(user))
		                    {
		                    	utilityClass.ShowMessage("Registered successfully!You can login now.",1);
		                    }
		                    break;
		     case 3: 
		    	     if(user !=null)
		    	     {
		    	    	 controller.logout(user);
		    	    	 user = null;
		    	     }
		    	     else
		    	     {
		    	    	 utilityClass.ShowMessage("No User logged in!",1);
		    	     }
		    	     break;
		     case 4:
		    	     System.exit(0);
		    	     
		     default: utilityClass.ShowMessage("Wrong choice!",1);
		  
		   }
		   break;
	   }
	   br.close();
   }
   private User getUserDetails() throws IOException
   {
	   User user = new User();
	   utilityClass.ShowMessage("Enter your name:-",1);
	   user.setFullName(br.readLine());
	   utilityClass.ShowMessage("Enter your user Id:-",1);
	   user.setUserId(br.readLine());
	   utilityClass.ShowMessage("Enter your password:-",1);
	   user.setPassword(br.readLine());
	   utilityClass.ShowMessage("Enter your password again:-",1);
	   user.setRePassword(br.readLine());
	   utilityClass.ShowMessage("Enter your role\n 1.Retailer \n 2.Sales-Representative\n Enter choice :-",1);
	   int choice = Integer.parseInt(br.readLine());
	   if(choice == 1)
	   {
		   user.setCategory("Retailer");
	   }
	   else
	   {
		   user.setCategory("Sales-Representative");
	   }
	   utilityClass.ShowMessage("Enter your phone number:-",1);
	   user.setNumber(br.readLine());
	   utilityClass.ShowMessage("Enter your email Id:-",1);
	   user.setEmail(br.readLine());
	   return user;
   }
}
