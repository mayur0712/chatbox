package com.cebs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cebs.beans.User;
import com.cebs.dao.DAO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getMethod().equals("POST") && request.getParameter("submit")!=null && request.getParameter("submit").equals("Login"))
		{
			if(!request.getParameter("email").equals("") && !request.getParameter("password").equals(""))
			{
				DAO dao = new DAO();
				User user = dao.validateUser(request.getParameter("email"), request.getParameter("password"));
				if(user!=null)
				{
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("welcome.jsp");
				}
				else
				{
					response.sendRedirect("index.jsp?msg=error");
				}
			}
			else
			{
				if(request.getParameter("email").equals(""))
				{
					response.sendRedirect("index.jsp?msg=email");
				}
				else
				{
					response.sendRedirect("index.jsp?msg=pass");
				}	
			}
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	}

}
