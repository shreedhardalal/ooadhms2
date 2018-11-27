package ooad.java.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ooad.java.database.*;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("unused")
@WebServlet(
		name = "UserLogin", 
		description = "user logins using this servlet", 
		urlPatterns = { 
				"/Login",
				"/UserLogin", 
				"/StudentLogin"
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == "" || username ==null) {
			String un=request.getParameter("username");
			String pw=request.getParameter("password");
			try {
				if(DatabaseHandler.AuthenticateUser(un,pw)==true) {
					session.setAttribute("username", un);
					response.sendRedirect("StudentHome.jsp");
				}
				else {
					response.getWriter().append("Wrong Combination try again");
				}
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			 // loads driver
//				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadhms?useSSL=true", "hmshost", "p"); // gets a new connection
//	 
//				PreparedStatement ps = c.prepareStatement("select student_name from student where student_id=? and student_password=?");
//				ps.setString(1, un);
//				ps.setString(2, pw);
//		 
//				ResultSet rs = ps.executeQuery();
//				//c.close();
//				while (rs.next()) {
//					session.setAttribute("username", un);
//					response.sendRedirect("StudentHome.jsp");
//					c.close();
//					return;
//				}
//				c.close();
//					response.getWriter().append("Wrong Combination try again");
//					return;
//			 } 
//			 catch (ClassNotFoundException | SQLException e) {
//					e.printStackTrace();
//			 }
		}
		else {
			//response.setContentType("text/html");
			response.sendRedirect("StudentHome.jsp");
		}		
	}

}
