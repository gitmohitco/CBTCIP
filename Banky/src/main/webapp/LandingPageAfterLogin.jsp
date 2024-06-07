<%@page import="com.nit.bank.BankRegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banky - A online banking application!!</title>
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
	#welcome{
		font-size: 20px;
	}
	main{
		height: 80vh;
		background: light-gray;
	}
	.banner{
		height: 80vh;
        text-align: center;
        display: flex;
        gap: 10px;
        justify-content: center;
        align-items: center;
        flex-direction: column;
	}
    .checkBal{
        width: 100%;
        text-decoration: none;
		padding: 7px;
		font-size: 1.2rem;
		border: none;
		border-radius: 4px;
		background: rgb(100, 100, 255);
		color: #fff;
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
					<li><a href="Withdraw.jsp">Withdraw</a></li>
					<li><a href="Transfer.jsp">Transfer</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>	
	</nav>
	<main>
		<div class="banner">
			<div >
				<%
				BankRegistrationBean bankregister = (BankRegistrationBean)session.getAttribute("loginsession"); 
				out.println("<h1><span id='welcome'>Wel Come, </span>"+bankregister.getOwnerName()+"</h1>");
				%>
			</div>
			<div>
				<a href="CheckBalance.jsp" class="checkBal">Check Balance</a>
			</div>
		</div>
		
	</main>
</body>
</html>