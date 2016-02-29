package com.java.spring.mvc.DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.hibernate.core.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public void save(User usr) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(usr);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().find("from User where username=?", username);
		if(list.size()==0){
			return null;
		} else {
			return (User) list.get(0);
		}
	}

}
