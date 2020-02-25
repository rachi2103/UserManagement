package cg.com.UserManagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cg.com.UserManagement.bean.User;
import cg.com.UserManagement.dao.UtilityClass;

public class ValidateUtil 
{
	static UtilityClass utilityClass1 = new UtilityClass();
    public static boolean loginValidation(String userId,String password)
    {
    	if(validateUserId(userId) && validatePassword(password,"",false))
    	{
    		return true;
    	}
    	return false;
    }
    public static boolean registerValidation(User user)
    {
    	if(validateUserId(user.getUserId()) && validatePassword(user.getPassword(),user.getRePassword(),true) && validateEmail(user.getEmail()) && validatePhone(user.getNumber()))
    	{
    		return true;
    	}
    	return false;
    }
    private static boolean validateEmail(String email)
    {
    	String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    	Pattern pattern = Pattern.compile(emailRegex);
    	Matcher matcher = pattern.matcher(email);
    	if(email.isEmpty())
    	{
    		utilityClass1.ShowMessage("User Doesn't exist!", 1);
    		return false;
    	}
    	else if(!matcher.matches())
    	{
    		utilityClass1.ShowMessage("Please enter a valid email!", 1);
    		return false;
    	}
    	return true;
    }
    private static boolean validatePhone(String phone)
    {
    	if(phone.isEmpty())
    	{
    		utilityClass1.ShowMessage("Phone number cannot be empty!", 1);
    		return false;	
    	}
    	else if(phone.length() != 10 || !phone.matches("^[1-9]\\d*$"))
    	{
    		utilityClass1.ShowMessage("Please enter a valid phone number!", 1);
    		return false;
    	}
    	return true;
    }
    private static boolean validateUserId(String userId)
    {
    	if(userId.isEmpty())
    	{
    		utilityClass1.ShowMessage("User Id cannot be empty!", 1);
    		return false;	
    	}
    	else if(!userId.matches("[A-Za-z0-9]+"))
    	{
    		utilityClass1.ShowMessage("Please enter a valid user Id!", 1);
    		return false;
    	}
    	return true;
    }
    private static boolean validatePassword(String password,String rePassword,boolean isRegister)
    {
    	if(password.isEmpty())
    	{
    		utilityClass1.ShowMessage("Password cannot be empty!", 1);
    		return false;	
    	}
    	else if(password.length() < 8)
    	{
    		utilityClass1.ShowMessage("Password must have atleast 8 characters!", 1);
    		return false;	
    	}
    	else if(!password.matches(".*[A-Z].*"))
    	{
    		utilityClass1.ShowMessage("Password must have atleast one uppercase letter!", 1);
    		return false;
    	}
    	else if(!password.matches(".*[a-z].*"))
    	{
    		utilityClass1.ShowMessage("Password must have atleast one lowercase letter!", 1);
    		return false;
    	}
    	else if(!password.matches(".*\\d.*"))
    	{
    		utilityClass1.ShowMessage("Password must have atleast one number character!", 1);
    		return false;
    	}
    	else if(!password.matches(".*[`~!@#$%^&*()\\\\-_=+\\\\\\\\|\\\\[{\\\\]};:'\\\',<.>/?].*"))
    	{
    		utilityClass1.ShowMessage("Password must contain atleast one special character!", 1);
    		return false;	
    	}
    	else if(isRegister && !password.equals(rePassword))
    	{
    		utilityClass1.ShowMessage("Password doesn't match!", 1);
    		return false;
    	}
    	return true;
    }
}
