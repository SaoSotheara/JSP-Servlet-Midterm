package com.itstep.htmltip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itstep.htmltip.service.UserService;

@WebServlet("/User")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 2L;
	UserService userService;
	
	public UserController() {
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (request.getParameter("username"));
		String password = (request.getParameter("password"));	
		if(userService.createUser(username, password) == 1) {
			request.setAttribute("success", "User created Successfully!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("fail", "Cannot create user!!!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
