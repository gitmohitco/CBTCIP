package com.nit.bank;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private TransferDAO transfer;
	public void init() {
		transfer = new TransferDAO();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException { 
		
		try {
			long senderId = Long.parseLong(request.getParameter("yourAccountNumber"));
			long receiverId = Long.parseLong(request.getParameter("benificiaryAccountNumber"));
			float amount = Float.parseFloat(request.getParameter("balance"));
			
			boolean transactionSuccess = transfer.balanceTransfer(senderId, receiverId, amount);
			
			if(transactionSuccess) {
				request.setAttribute("message", "Transfer successful!");
			}else {
				request.setAttribute("message", "Transfer failed. Please check the account details and balance.");
			}
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
