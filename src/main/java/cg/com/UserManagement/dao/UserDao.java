package cg.com.UserManagement.dao;


import cg.com.UserManagement.bean.User;

public interface UserDao 
{
   User login(String username,String password);
   boolean register(User user);
   void logout(User user);

}
