package cg.com.UserManagement.dao;

import java.util.logging.Logger;


public class UtilityClass {
	
	   public void ShowMessage(String str,int code)
	   {
		   Logger log=Logger.getLogger(UserDao.class.getName());
		   if(code==1)
		   {
			   System.out.println(str);
		   }
		   else
		   {
			 log.info(str);   
		   }
	   }

}
