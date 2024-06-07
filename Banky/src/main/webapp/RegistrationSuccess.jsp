<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration successful!</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
	*{
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		font-family: "Poppins", sans-serif;
	}
	body{
		display: flex;
		height: 100vh;
		flex-direction: column;
		justify-content:center;
		align-items: center;
		gap: 5px;
	}
	a{
		color: red;
		font-size: 1rem;
	}
	p{
		font-size: 1.3rem;
		color: green;
		font-weight: 500;
	}
</style>
</head>
<body>
	<%
		String message = (String)request.getAttribute("message");
		out.println("<p>"+message+"</p>");
	%>
	<a href="index.html">Go to login</a>
</body>
</html>