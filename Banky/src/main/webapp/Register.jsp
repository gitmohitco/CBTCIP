<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banky - A Banking Application || Registration</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
	*{
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		font-family: "Poppins", sans-serif;
	}
	main{
		height: 100vh;
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
    form input[type=text],input[type=password],input[type=tel]{
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
	a{
		color: red;
		font-size: 1.1rem;
	}
	p{
		color: red;
		font-size: 1.1rem;
	}
</style>
</head>
<body>
	<main>
		<form action="registration" method="post">
		<h2>Registration</h2>
		<input type="text" placeholder="Username" name="username"/>
		<input type="password" placeholder="Password" name="password"/>
		<input type="text" placeholder="Your Name" name="name">
		<input type="tel" placeholder="Account Number" name="accNumber"/>
		<input type="tel" placeholder="Mobile Number" name="mobNumber"/>
		<input type="text" placeholder="Account type" name="accType"/>
		<input type="hidden" placeholder="Balance" value=0 readonly >
		<input type="submit" value="Register">
		<a href="index.html">Login</a>
		<%
			String msg = (String)request.getAttribute("message");
			out.println("<p>"+msg+"</p>");
		%>
		</form>
	</main>
</body>
</html>