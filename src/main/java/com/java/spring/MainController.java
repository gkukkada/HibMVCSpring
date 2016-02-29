package com.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.hibernate.core.entity.*;
import com.java.spring.mvc.BO.*;
import com.java.spring.validations.Validation;

/**
 * Servlet implementation class HelloController
 */
@Controller
public class MainController {

	@RequestMapping(value = "/index.html")
	protected ModelAndView handleRequestInternal() {
		// TODO Auto-generated method stub
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/register")
	protected ModelAndView redirectRegister() {
		// TODO Auto-generated method stub
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/id")
	protected ModelAndView redirectidpage() {
		// TODO Auto-generated method stub
		return new ModelAndView("id");
	}

	@RequestMapping(value = "/employee")
	protected ModelAndView employeepage() {
		// TODO Auto-generated method stub
		return new ModelAndView("employee");
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	protected ModelAndView userValidator(@ModelAttribute("user") User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		String password = user.getPassword();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		UserBO usr = (UserBO) appContext.getBean("userBO");

		if (usr.findUserByUsername(user.getUsername()) != null && username != "") {
			User u = usr.findUserByUsername(user.getUsername());
			if (Validation.isUserValid(u, username, password)) {
				return new ModelAndView("id");
			} else {
				return new ModelAndView("index").addObject("err", "Invalid Username and Password.");
			}
		} else {
			return new ModelAndView("index").addObject("err", "No Username Found.");
		}
	}

	@RequestMapping(value = "/empID", method = RequestMethod.POST)
	protected ModelAndView employeeValidator(@RequestParam("id") int id, @RequestParam("name") String name) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		EmployeeBO empbo = (EmployeeBO) appContext.getBean("employeeBO");
		try {
			if (id != 0) {
				Employee emp = empbo.findByEmpId(id);
				return new ModelAndView("employee").addObject("empObj", emp);
			} else {
				return new ModelAndView("id").addObject("err", "Employee ID not found.");
			}

		} catch (Exception ex) {
			return new ModelAndView("id").addObject("err", "Employee ID not found.");
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registration(@ModelAttribute("user") User user) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		UserBO usr = (UserBO) appContext.getBean("userBO");
		try {
			if (usr.findUserByUsername(user.getUsername()) == null) {
				usr.save(user);
				return new ModelAndView("index");
			} else {
				return new ModelAndView("register").addObject("err", "Username already there.");
			}
		} catch (Exception ex) {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	protected ModelAndView deleteEmployee(@RequestParam("id") int id) {
		System.out.println("came to delete");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		EmployeeBO empbo = (EmployeeBO) appContext.getBean("employeeBO");
		Employee emp = empbo.findByEmpId(id);
		empbo.delete(emp);
		return new ModelAndView("employee").addObject("success", "success");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	protected ModelAndView updateEmployee(@ModelAttribute("emp") Employee emp) {
		System.out.println("came to add");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		EmployeeBO empbo = (EmployeeBO) appContext.getBean("employeeBO");
		System.out.println(emp.toString());
		if (empbo.findByEmpId(emp.getId()) == null) {
			empbo.save(emp);
			return new ModelAndView("employee").addObject("empObj", emp);
		} else {
			return new ModelAndView("error");
		}
	}
}
