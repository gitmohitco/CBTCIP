package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/check") 
public class CheckBalanceServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		long accountNumber = Long.parseLong(request.getParameter("yourAccountNumber"));
		String password = request.getParameter("password");
		
		BankRegistrationBean check = new CheckBalanceDAO().checkBalance(accountNumber, password);
		
		if(check==null) {
			request.setAttribute("message", "Invalid password!");
			request.getRequestDispatcher("CheckBalance.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("check", check);
			request.getRequestDispatcher("AmountInAccount.jsp").forward(request, response);
		}
	}
}
