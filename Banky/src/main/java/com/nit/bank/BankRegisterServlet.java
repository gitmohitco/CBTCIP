package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/registration")
public class BankRegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		BankRegistrationBean bankregister = new BankRegistrationBean();
		
		bankregister.setUserName(request.getParameter("username"));
		bankregister.setUserPassword(request.getParameter("password"));
		bankregister.setOwnerName(request.getParameter("name"));
		bankregister.setAccountNumber(Long.parseLong(request.getParameter("accNumber")));
		bankregister.setMobileNumber(Long.parseLong(request.getParameter("mobNumber")));
		bankregister.setUserAccounttype(request.getParameter("accType"));
		int k = new BankRegisterDAO().bank_register(bankregister);
		if(k>0) {
			request.setAttribute("message", "Registration Successful");
			request.getRequestDispatcher("RegistrationSuccess.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Invalid credential, try again!");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}
}
