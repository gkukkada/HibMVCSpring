package com.java.spring.mvc.BO;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.hibernate.core.entity.User;
import com.java.spring.mvc.DAO.UserDAO;

public class UserImpl implements UserBO {
	
	@Autowired
	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void save(User usr) {
		// TODO Auto-generated method stub
		userDAO.save(usr);
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub	
		return userDAO.findByUsername(username);
	}

}
