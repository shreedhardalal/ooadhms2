<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ooad.java.coreclass.Complaint" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Welcome student</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

   <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <%
          if((String)session.getAttribute("username")==null||(String)session.getAttribute("username")=="")
          	response.sendRedirect("login.jsp");
          out.println("Welcome : " + (String)session.getAttribute("username"));	
          %>
          <br>
          <a href="Logout.jsp">Logout</a>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          Submit a new complaint	
          <form role="form" action="ClassifyComplaint" method="post">
            <div class="form-group">
              <label for="ComplaintInput">
                Enter Complaint
              </label>
              <input type="text" class="form-control" id="complaint" name="complaint"/>
            </div> 
            <button type="submit" class="btn btn-primary">
              Submit Complaint
            </button>
          </form>
        </div>
        <div class="col-md-6">
        </div>
        
      </div>
		<div class="row">
		  <div class="col-md-12">
		    <table class="table">
		      <thead>
		        <tr>
		          <th> Complaint <br> id </th>
		          <th> status </th>
		          <th> Created on </th>
		          <th> Set status <br>If any </th>
		        </tr>
		      </thead>
		      <tbody>
		        <%
		        Complaint com = new Complaint();
            	ArrayList<Complaint> complaints = com.GetComplaints((String)session.getAttribute("username"));	
            	for(int i=0;i<complaints.size();i++){
            		out.println("<tr>");
            		out.println("<td>"+complaints.get(i).id);
            		out.println("<td>"+complaints.get(i).comp_status);
            		out.println("<td>"+complaints.get(i).comp_reg_date);
            		if(!complaints.get(i).comp_status.equalsIgnoreCase("complete")){
            			out.print("<td>");
            			out.println("<form role=\"form\" action=\"SetStatus.jsp\" method=\"post\">");
            			out.println("<input type=\"hidden\" name=\"complaintid\" value=\""+complaints.get(i).id+"\"\\>");
            			out.println("<button type=\"submit\" class=\"btn btn-primary\">complete<//button><//form>");
            		}
            	}
		        %>
		      </tbody>
		    </table>
		  </div>
		</div>     
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>