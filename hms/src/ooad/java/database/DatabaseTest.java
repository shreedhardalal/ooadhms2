package ooad.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseTest {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String un=in.nextLine();
		String pw=in.nextLine();
		
		in.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadhms?useSSL=true", "hmshost", "p"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select student_name from student where student_id=? and student_password=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			//response.getWriter().append("Welcome: "+rs.getString(1));
			System.out.println("Welcome: "+rs.getString(1));
			c.close();
			return;
		}
		c.close();
			//response.getWriter().append("Wrong Combination try again");
			//return;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
