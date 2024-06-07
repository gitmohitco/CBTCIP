package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class BankLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String login_username = request.getParameter("username");
		String login_password = request.getParameter("password");
		BankRegistrationBean login_bankregister = new BankLoginDAO().login(login_username, login_password);
		if(login_bankregister == null) {
			request.setAttribute("message", "Invalid Login credential!");
			request.getRequestDispatcher("ErrorMessage.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginsession", login_bankregister);
			request.getRequestDispatcher("LandingPageAfterLogin.jsp").forward(request, response);
		}
	}

}
