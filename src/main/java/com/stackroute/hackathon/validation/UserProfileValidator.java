package com.stackroute.hackathon.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import java.util.regex.Matcher;

@Component
public class UserProfileValidator {
	public void validateUserEmail(String emailId) throws Exception {
	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	Matcher matcher = p.matcher(emailId);
	if(!matcher.find()) 
		throw new Exception();
	}
	public void ValidateName(String userName) throws Exception{
		if(userName==null)
			throw new Exception();
		if(userName.equals("")) {
			throw new Exception();
		}
	}
}
