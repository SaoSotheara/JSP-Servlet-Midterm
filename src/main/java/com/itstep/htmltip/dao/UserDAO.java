package com.itstep.htmltip.dao;

import com.itstep.htmltip.model.User;

public interface UserDAO {

	
	int createUser(String username, String password);
	
	User getOneByUsername(String username);
}
