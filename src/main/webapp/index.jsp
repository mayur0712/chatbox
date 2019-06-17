<html>
<body>
	<%
		if(session!=null && session.getAttribute("user")!=null)
		{
			response.sendRedirect("welcome.jsp");
		}
	
		if(request.getMethod().equals("GET") && request.getParameter("msg")!=null && request.getParameter("msg").equals("error"))
		{
			out.print("Email ID or password Invalid");
		}
	%>
	<form action="LoginController" method="POST">
		<input type="text" name="email" placeholder ="Email">
		<%
		if(request.getMethod().equals("GET") && request.getParameter("msg")!=null && request.getParameter("msg").equals("email"))
		{
			out.print("Fields are Empty1");
		}
		%>
		<br>
		<input type="password" name="password" placeholder ="Password">
		<%
		if(request.getMethod().equals("GET") && request.getParameter("msg")!=null && request.getParameter("msg").equals("pass"))
		{
			out.print("Fields are Empty2");
		}
		%>
		<br>
		
		<input type="submit" name="submit" value="Login"><br>
	</form>
</body>
</html>
