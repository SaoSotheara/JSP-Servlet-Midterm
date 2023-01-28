package com.itstep.htmltip.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itstep.htmltip.dao.UserDAO;
import com.itstep.htmltip.model.User;
import com.itstep.htmltip.utils.ConnectionUtil;

public class UserService implements UserDAO {
	
	Connection connection;

	@Override
	public int createUser(String username, String password) {
		try {
			String sql = "INSERT into User (username, password) VALUES" + "('"+ username + "','" + password +"')";
			this.connection = ConnectionUtil.getConnection();
			var preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<User>();;
		try {
			String sql = "SELECT * FROM Tip";
			this.connection = ConnectionUtil.getConnection();
			var statement = this.connection.createStatement();
			var resultSet = statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User getOneByUsername(String username) {
		var user = new User();
		try {
			String sql = "SELECT * FROM User where username='"+username+"'";
			this.connection = ConnectionUtil.getConnection();
			var statement = this.connection.createStatement();
			var resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				user.setPassword(resultSet.getString("password"));
				user.setUsername(resultSet.getString("username"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
