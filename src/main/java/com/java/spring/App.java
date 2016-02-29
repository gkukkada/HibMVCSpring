package com.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.mvc.BO.EmployeeBO;
import com.java.spring.mvc.BO.EmployeeImpl;
import com.java.spring.mvc.BO.UserBO;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		System.out.println("after appcontext");
		EmployeeBO empbo = (EmployeeImpl) appContext.getBean("employeeBO");
		if (empbo.findByEmpId(3) != null) {
			System.out.println("in if");
			System.out.println(empbo.findByEmpId(3).toString());
		} else {
			System.out.println("in else");
		}
//		UserBO userbo = (UserBO) appContext.getBean("userBO");
//		System.out.println(userbo.findUserByUsername("test").toString());
	}
}
