<%@page import="com.nit.bank.BankRegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Balance</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
	*{
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		font-family: "Poppins", sans-serif;
	}
	main{
		height: 80vh;
		background: light-gray;
        display: flex;
        gap: 5px;
        flex-direction:column;
        justify-content: center;
        align-items: center;
	}
	.warp{
        display: flex;
        flex-direction:column;
        align-items: center;
	}
	a{
		width: 100%;
		padding: 7px;
		font-size: 1.2rem;
		color: red;
		margin-top: 5px;
	}
	h1{
		color: green;
	}
</style>
</head>
<body>
	<main>
		<div class="warp">
			<div>
			<p>Available Balance</p>
		</div>
		<div>
			<%
				BankRegistrationBean register = (BankRegistrationBean)session.getAttribute("check");
				out.println("<h1>"+register.getBalance()+"</h1>");
			%>		
		</div>
		</div>
		<div>
			<a href="LandingPageAfterLogin.jsp">Home</a>
		</div>
	</main>
</body>
</html>