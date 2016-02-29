package com.java.spring.mvc.DAO;

import com.java.hibernate.core.entity.User;

public interface UserDAO {
	void save(User usr);
	User findByUsername(String username);
}
