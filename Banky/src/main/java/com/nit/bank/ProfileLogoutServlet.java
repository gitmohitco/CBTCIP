package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class ProfileLogoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.removeAttribute("loginsession");
			session.invalidate();
		}
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}
}
