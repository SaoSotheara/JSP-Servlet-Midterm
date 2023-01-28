package com.itstep.htmltip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.htmltip.model.User;
import com.itstep.htmltip.service.UserService;

@WebServlet("/Auth")
public class AuthController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	
	public AuthController() {
		this.userService = new UserService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = this.userService.getOneByUsername(username);
		if(user.getUsername() == null && user.getPassword() != password) {
			request.setAttribute("fail", "Invalid credentials.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		Cookie loginCookie = new Cookie("usernameAndPassword", username + password);
		response.addCookie(loginCookie);
		response.sendRedirect(request.getContextPath());
	}
}
