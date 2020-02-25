package cg.com.UserManagement.controller;

import cg.com.UserManagement.bean.User;
import cg.com.UserManagement.dao.UserDao;
import cg.com.UserManagement.dao.UserDaoImp;
import cg.com.UserManagement.util.ValidateUtil;

public class UserController 
{
  private UserDao userDao;
  public UserController()
  {
	  super();
	  userDao = new UserDaoImp();
  }
  public User login(String username,String password)
  {
	  if(ValidateUtil.loginValidation(username,password))
	  {
		  return userDao.login(username, password);
	  }
	  return null;
  }
  public boolean register(User user)
  {
	  if(ValidateUtil.registerValidation(user))
	  {
		  return userDao.register(user);
	  }
	  return false;
  }
  public void logout(User user)
  {
	  if(user!=null)
	  {
		  userDao.logout(user);
	  }
  }
}
