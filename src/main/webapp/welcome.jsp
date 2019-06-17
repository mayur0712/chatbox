<%@page import="com.cebs.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to CEBS</title>
</head>
<body>
	<%
		if(session!=null && session.getAttribute("user")!=null)
		{
	%>
	<p>Welcome 
	<%
		User user = (User)session.getAttribute("user");
		out.print(user.getFname());
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	%> 
	</p>
	
	<a href="Logout" style="float:right">Logout</a>
</body>
</html>