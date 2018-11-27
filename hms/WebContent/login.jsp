<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Welcome Bitsians!!</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>
	<%
		if((String)session.getAttribute("username") != null && (String)session.getAttribute("username") != "")
			response.sendRedirect("StudentHome.jsp");
	%>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="StudentLogin" method="post">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						User name
					</label>
					<input type="text" class="form-control" value="20180283" id="exampleInputEmail1" name="username">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						Password
					</label>
					<input type="password" class="form-control" value="1122334455" id="exampleInputPassword1" name="password">
				</div>
				<button type="submit" class="btn btn-primary">
					Submit
				</button>
			</form>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>