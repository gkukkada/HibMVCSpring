package com.java.spring.mvc.BO;

import com.java.hibernate.core.entity.User;

public interface UserBO {
	void save(User usr);
	User findUserByUsername(String username);
}
