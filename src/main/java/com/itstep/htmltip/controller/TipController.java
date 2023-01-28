package com.itstep.htmltip.controller;

import java.io.IOException;
import com.itstep.htmltip.model.User;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itstep.htmltip.dao.TipDAO;
import com.itstep.htmltip.model.Tip;
import com.itstep.htmltip.service.TipService;
import com.itstep.htmltip.service.UserService;

@WebServlet("/")
public class TipController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	TipDAO tipService = null;
	UserService userService;
	
	public TipController() {
		tipService = new TipService();
		this.userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		
		if(action == "DELETE") {
			List<User> users = this.userService.getAll();
			if(users.size() < 1) {
				action = "LIST";
			}
		}
		
		switch(action) {
			
			case "LIST":
				getAll(request, response);
				break;
				
			case "DETAIL":
				getOneById(request, response);
				break;
				
			case "DELETE":
				deleteTip(request, response);
				break;
				
			default:
				getAll(request, response);
				break;
				
		}
		
	}
	
	private void deleteTip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(tipService.delete(Integer.parseInt(id)) == 1) {
			request.setAttribute("message", "Tip Deleted Successfully!");
		}
		this.getAll(request, response);
	}

	private void getOneById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		Tip tip = tipService.getOneById(Integer.parseInt(id));
		String[] htmlString = tip.getExampleHtmlEscape().split("<br/>");
		request.setAttribute("tip", tip);
		request.setAttribute("htmlString", htmlString);
		
		request.getRequestDispatcher("/tipDetails.jsp").forward(request, response);
	}

	void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tip> tips = tipService.getAll();
		
		request.setAttribute("tips", tips);
		
		request.getRequestDispatcher("tips.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tip tip = new Tip();
		tip.setTitle(request.getParameter("title"));
		tip.setDescription(request.getParameter("description"));
		tip.setExampleHtmlEscape(request.getParameter("exampleHtmlEscape"));		
		if(tipService.createTip(tip) == 1) {
			request.setAttribute("success", "Tip created Successfully!");
		} else {
			request.setAttribute("fail", "Cannot create tip!!!");
		}
		request.getRequestDispatcher("tipCreation.jsp").forward(request, response);
	}

}
