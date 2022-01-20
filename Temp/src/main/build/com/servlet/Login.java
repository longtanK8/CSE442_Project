package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user_name");
		String password = request.getParameter("password");

		User user = new User();
//		HttpSession session = request.getSession();
//		session.setAttribute("uname", username);
		if (user.checkAuthority(username, password)) {
			
			Cookie ck = new Cookie("uname", username);
			response.addCookie(ck);
			ck = new Cookie("avatar", user.getPicturePath());
			response.addCookie(ck);
			
			response.sendRedirect("homepage.html");
		} else {
			out.print("<style>.authority {display: block !important;}</style>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
