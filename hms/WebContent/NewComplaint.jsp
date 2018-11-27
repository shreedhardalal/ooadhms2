<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if((String)session.getAttribute("username")==null||(String)session.getAttribute("username")=="")
			response.sendRedirect("/Login.html");
	
	
		out.println("Welcome : " + (String)session.getAttribute("username"));
	%>
	<form action="RegisterComplaint" method="post">
			Complaint :<input type="text" name="complaint"> <br>
			<input type="submit" value="Login">
	</form>

</body>
</html>