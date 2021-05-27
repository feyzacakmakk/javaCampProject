package day5homework1.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import day5homework1.business.abstracts.CheckService;

public class MailCheckManager implements CheckService{
	
	boolean isEmailValid(String email) {
	    String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = email;
	 
	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    return matcher.matches();
	  }
	
}
