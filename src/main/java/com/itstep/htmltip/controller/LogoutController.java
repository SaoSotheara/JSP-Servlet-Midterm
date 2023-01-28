package com.itstep.htmltip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LogoutController() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("usernameAndPassword", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
	    response.sendRedirect(request.getContextPath());
	}
	
}
