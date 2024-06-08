<%@page import="com.nit.bank.BankRegistrationBean"%>
<%@page import="com.nit.bank.BankRegisterDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposite - Section for deposite</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
	*{
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		font-family: "Poppins", sans-serif;
	}
	nav{
		background: #000;
		padding: 12px 10px;
		position: sticky;
		top:0px;
		box-shadow: 1px 1px 6px gray;
	}
	.nav{
		display: flex;
		justify-content: space-between;
	}
	.logo>img{
	    margin-top: 3px;
		height: 50px;
		width: 150px;
	}
	.navbar>ul{
		display: flex;
		gap: 20px;
		margin-top: 15px;
	}
	.navbar>ul>li{
		list-style: none;
	}
	.navbar>ul>li>a{
		text-decoration: none;
		color: #fff;
		font-size: 1rem;
	}
	main{
		height: 80vh;
		background: light-gray;
        display: flex;
        justify-content: center;
        align-items: center;
	}
	form{
		display: flex;
		flex-direction: column;
        width: 100%;
        padding: 20px;
        text-align: center;
        gap: 10px;
        width: 350px;
	}
    form input[type=number],input[type=text]{
        width: 100%;
		padding: 7px 4px;
		border: 1px solid gray;
		border-radius: 5px;
		outline: none;
    	font-size: 1.1rem;
    }
    form input[type=submit]{
		width: 100%;
		padding: 7px;
		font-size: 1.2rem;
		border: none;
		border-radius: 4px;
		background: rgb(100, 100, 255);
		color: #fff;
		margin-top: 5px;
	}
	p{
		color: red;
		font-size: 1rem;
	}
</style>
</head>
<body>
	<nav>
		<div class="nav">
			<div class="logo"><img src="Banky-img2.png"></div>
			<div class="navbar">
				<ul>
					<li><a href="LandingPageAfterLogin.jsp">Home</a></li>
					<li><a href="Deposite.jsp">Deposit</a></li>
					<li><a href="withdraw">Withdraw</a></li>
					<li><a href="Transfer.jsp">Transfer</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>	
	</nav>
	<main>
	<%
		BankRegistrationBean register = (BankRegistrationBean)session.getAttribute("loginsession");
	%>
		<form action="deposite" method="post">
			<h2>Deposite</h2>
			<input type="number" name="accountNumber" placeholder="Account Number" value=<%=register.getAccountNumber() %> readonly>
			<input type="text" name="ownerName" placeholder="Holder Name" value=<%=register.getOwnerName() %>>
			<input type="number" name="balance" placeholder="Balance">
			<input type="text" name="accType" placeholder="Account Type" value=<%=register.getUserAccounttype() %>>
			<%
				String message = (String)request.getAttribute("message");
				out.println("<p>"+message+"</p>");
			%>
			<input type="submit" value="Deposite">
		</form>
	</main>
</body>
</html>