package cg.com.UserManagement.dao;

import java.util.HashMap;
import java.util.Map;

import cg.com.UserManagement.bean.User;

public class UserDaoImp implements UserDao
{
   private static Map<String,User> userDb = new HashMap<String, User>();
   UtilityClass utilityClass=new UtilityClass();
   public UserDaoImp()
   {
	   super();
	   setUserMap();
   }
   public void setUserMap()
   {
	   userDb.put("rachi2103", new User("Rachit Dang","Admin","rachi2103","#Radhika0803","9971821646","rachi.dang@gmail.com"));
	   userDb.put("radhi0803", new User("Radhika Dang","Sales-Representative","radhi0803","#Rachit0803","9971821645","radhi.dang@gmail.com"));
	   userDb.put("rishi2203", new User("Rishi Kapoor","Retailer","rish2203","#Rishika0803","9971821644","rishi.kapoor@gmail.com"));
	   userDb.put("renu2707", new User("Renu Dang","Product Manager","renu2707","#RadhikaRachit","9971821643","renu.dang@gmail.com"));
	   userDb.put("bhupesh1609", new User("Bhupesh Dang","Service Delivery Analyst","bhupesh1609","#RachitRadhika","9971821642","bhupesh.dang@gmail.com"));
	   userDb.put("raj1234", new User("Raj Kashyap","Address Database Manager","raj1234","#Rajkash0803","9971821641","raj.kashyap@gmail.com"));
   }
   public User login(String username,String password)
   {
	   User user = searchUser(username);
	   if(user == null)
	   {
		   utilityClass.ShowMessage("User Doesn't exist!", 1);
		   return null;
	   }
	   else if(!user.getPassword().equals(password))
	   {
		   utilityClass.ShowMessage("Invalid Password!", 1);
		   return null;
	   }
	   return user;
   }
   public boolean register(User user)
   {
	   if(searchUser(user.getUserId())==null)
	   {
		   userDb.put(user.getUserId(), user);
		   return true;
	   }
	   else
	   {
		   utilityClass.ShowMessage("User already exists!", 1);
		   return false;
	   }
   }
   public void logout(User user)
   {
	   if(user!=null)
	   {
		   if(searchUser(user.getUserId())!=null)
		   {
			   System.out.println(user.getFullName() + " has successfully logged out!");
			   userDb.get(user.getUserId()).setLoggedIn(false);
		   }
	   }
   }
   private User searchUser(String username)
   {
	   if(userDb.containsKey(username))
	   {
		   return userDb.get(username);
	   }
	   return null;
   }
}
