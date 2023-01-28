package com.itstep.htmltip.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itstep.htmltip.dao.TipDAO;
import com.itstep.htmltip.model.Tip;
import com.itstep.htmltip.utils.ConnectionUtil;

public class TipService implements TipDAO {

	Connection connection;
	private List<Tip> tips;
	
	@Override
	public int createTip(Tip tip) {
		try {
			String sql = "INSERT into Tip (title, description, exampleHtmlEscape) VALUES" + "('"+ tip.getTitle()+ "','" + tip.getDescription() + "','"+ tip.getExampleHtmlEscape() + "')";
			this.connection = ConnectionUtil.getConnection();
			var preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<Tip> getAll() {
		tips = new ArrayList<Tip>();;
		try {
			String sql = "SELECT * FROM Tip";
			this.connection = ConnectionUtil.getConnection();
			var statement = this.connection.createStatement();
			var resultSet = statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Tip tip = new Tip();
				tip.setId(resultSet.getInt("id"));
				tip.setTitle(resultSet.getString("title"));
				tip.setDescription(resultSet.getString("description"));
				tip.setExampleHtmlEscape(resultSet.getString("exampleHtmlEscape"));
				tips.add(tip);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tips;
	}

	@Override
	public Tip getOneById(int id) {
		Tip tip = new Tip();
		System.out.println(id);
		try {
			String sql = "SELECT * FROM Tip WHERE id="+id;
			this.connection = ConnectionUtil.getConnection();
			var statement = this.connection.createStatement();
			statement.setMaxRows(1);
			var resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				tip.setId(resultSet.getInt("id"));
				tip.setTitle(resultSet.getString("title"));
				tip.setDescription(resultSet.getString("description"));
				tip.setExampleHtmlEscape(resultSet.getString("exampleHtmlEscape"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tip;
	}

	@Override
	public int delete(int id) {
		try {
			String sql = "DELETE FROM Tip where id="+id;
			this.connection = ConnectionUtil.getConnection();
			var statement = this.connection.createStatement();
			statement.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
