package com.java.spring.mvc.BO;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.hibernate.core.entity.Employee;
import com.java.spring.mvc.DAO.EmployeeDAO;


public class EmployeeImpl implements EmployeeBO {
	
	@Autowired
	EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		employeeDAO.save(emp);
	}

	public void update(Employee emp) {
		// TODO Auto-generated method stub
		employeeDAO.update(emp);
	}

	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		employeeDAO.delete(emp);
	}

	public Employee findByEmpId(int id) {
		return employeeDAO.findByEmpId(id);
	}

}
