package com.java.spring.mvc.DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.hibernate.core.entity.Employee;

public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(emp);
	}

	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(emp);
	}

	public void update(Employee emp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(emp);
	}

	public Employee findByEmpId(int empid) {
		List list = getHibernateTemplate().find("from Employee where id=?", empid);
		if (list.size() < 1) {
			return null;
		} else {
			return (Employee) list.get(0);
		}
	}

}
