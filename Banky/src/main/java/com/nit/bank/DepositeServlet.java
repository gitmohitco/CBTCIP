package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/deposite")
public class DepositeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		float balance = 0;
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("message", "Session Expired!");
		}else {
			long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
			balance += Float.parseFloat(request.getParameter("balance"));
			BankRegistrationBean register = (BankRegistrationBean)session.getAttribute("loginsession");
				if(accountNumber == register.getAccountNumber()) {
					register.setBalance(balance);
					int k = new DepositeDAO().depositeit(register);
					if(k>0) {
						request.setAttribute("message", "Transaction Successful!!");
					}
				}else 
					request.setAttribute("message", "Transaction failed!!");
			request.getRequestDispatcher("Deposite.jsp").forward(request, response);
		}
	}
}
