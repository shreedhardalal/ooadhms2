<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ooad.java.coreclass.Complaint" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Complaint com = new Complaint();
	com.UpdateStatus(Integer.parseInt((String)request.getAttribute("complaintid")),"complete");
	%>
	<form action="feedback.jsp">
		Select radio button to rate service
		<%
			out.println("<input type=\"hidden\" name=\"complaintid\" value=\""+(String)request.getAttribute("complaintid")+"\"\\>");
			for(int i=1;i<=10;i++){
				out.println("<br>"+i+"<input type=\"radio\" name=\"rating\" value=\""+i+"\\>" );
			}
		%>
		<input type="submit"\>
	</form>
	
</body>
</html>