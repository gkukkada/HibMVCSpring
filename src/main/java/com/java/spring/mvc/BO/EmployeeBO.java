package com.java.spring.mvc.BO;

import com.java.hibernate.core.entity.Employee;

public interface EmployeeBO {
	void save(Employee emp);
	void update(Employee emp);
	void delete(Employee emp);
	Employee findByEmpId(int id);
}	
