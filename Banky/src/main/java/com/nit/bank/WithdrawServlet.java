package com.nit.bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("message", "Session Expired!");
		}else {
			BankRegistrationBean register = (BankRegistrationBean)session.getAttribute("loginsession");
			long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
			float balance = Float.parseFloat(request.getParameter("balance"));
				if(accountNumber == register.getAccountNumber() && balance<=register.getBalance()) {
					register.setBalance(balance);
					int k = new WithdrawDAO().withdrawit(register);
					if(k>0) {
						request.setAttribute("message", "Transaction Successfull!!");
					}
				}else {
					request.setAttribute("message", "Transaction failed");
				}
			request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
		}
	}
}
