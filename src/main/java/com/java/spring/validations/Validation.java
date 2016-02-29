package com.java.spring.validations;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;

public class Validation {
	public static boolean isUserValid(User usr, String username, String password){
		boolean bool = false;
		if(password.equals(usr.getPassword())){
			bool = true;
		} 
		return bool;
	}
	
/*	public static boolean isIdValid(Employee emp, int id){
		boolean bool=false;
		if(id==emp.getId()){
			bool=true;
		}
		return bool;
	}*/
}
