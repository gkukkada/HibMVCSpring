package com.java.spring.mvc.DAO;

import com.java.hibernate.core.entity.Employee;

public interface EmployeeDAO {
	void save(Employee emp);
	void delete(Employee emp);
	void update(Employee emp);
	Employee findByEmpId(int empid);
}	
