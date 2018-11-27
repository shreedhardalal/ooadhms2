package ooad.java.database;
import static ooad.java.database.DatabaseParameter.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ooad.java.coreclass.Complaint;

@SuppressWarnings("unused")
public class DatabaseHandler {
	
	public static void main(String args[]) throws ClassNotFoundException {
		/*try {
			Class.forName(ClassForname);
			try {
				Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
				
				//System.out.println(AuthenticateUser("20180283","1122334455",c));
				
				c.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Complaint com  = new Complaint();
		System.out.println(AddComplaint("20180283","bathroom urinal getting clogged","plumber"));
		
		
	}
	
	/*public static boolean AddStudent(Connection c) {
		Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
		return false;
	}*/
	
	public static boolean AuthenticateUser(String Username, String Password) throws ClassNotFoundException {
		Class.forName(ClassForname);
		String statement = "select student_name from student where student_id=? and student_password=?";
		try {
			Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setString(1, Username);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean AddComplaint(String username,String Complaint,String Class_label) throws ClassNotFoundException {
		Class.forName(ClassForname);
		String statement = "INSERT INTO `ooadhms`.`complaint` (`student_complaint_id`, `complaint_text`, `worker_complaint_id`, `complaint_class`, `complaint_date`, `complaint_status`, `complaint_feedback`) VALUES ("+username+", '"+Complaint+"', NULL, '"+Class_label+"', DEFAULT, 'raised', NULL);";
		try {
			Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
			PreparedStatement ps = c.prepareStatement(statement);
			//ps.setString(1, username);
			//ps.setString(2, Complaint);
			//ps.setString(3, Class_label);
			boolean rs = ps.execute();
			//while (rs.next()) {
				c.close();
				return true;
			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean UpdateComplaintStatus(int id,String status) throws ClassNotFoundException{
		Class.forName(ClassForname);
		//String statement = "select * from student;";
		String statement = "UPDATE complaint SET  complaint_status= \""+status+"\" where complaint_id = "+id+";";
		try {
			Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
			PreparedStatement ps = c.prepareStatement(statement);
			boolean rs = ps.execute();			
			c.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Complaint> GetWorkerFeedback() throws ClassNotFoundException{
		ArrayList<Complaint> complaints = new ArrayList<Complaint>();;
		int id=0;
		String comp="";
		String comp_class="";
		String comp_reg_date="";
		String comp_serv_date="";
		String comp_status="";
		int feedback=0;
		Class.forName(ClassForname);
		String statement = "select worker_name,AVG(complaint_feedback) AS avgfeedback from (complaint inner join worker w on complaint.worker_complaint_id = w.worker_id) group by worker_id;";
		try {
			Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
			PreparedStatement ps = c.prepareStatement(statement);
			//ps.setString(1, username);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getInt("complaint_id")+rs.getString("complaint_reg_date")+rs.getString("latest_service_date")+rs.getString("complaint_status"));
				complaints.add(new Complaint(0,rs.getString("worker_name"),"","","",rs.getString("avgfeedback"),0));
				//System.out.println(rs.getString(1));
			}
			c.close();
			return complaints;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Complaint> GetStudentComplaint(String username) throws ClassNotFoundException{
		ArrayList<Complaint> complaints = new ArrayList<Complaint>();;
		int id=0;
		String comp="";
		String comp_class="";
		String comp_reg_date="";
		String comp_serv_date="";
		String comp_status="";
		int feedback=0;
		Class.forName(ClassForname);
		//String statement = "select * from student;";
		String statement = "select * from student_latest_complaint_service where student_id = ? order by complaint_id;";
		try {
			Connection c = DriverManager.getConnection(DBConnString,DBConnUser,DBConnPassword);
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getInt("complaint_id")+rs.getString("complaint_reg_date")+rs.getString("latest_service_date")+rs.getString("complaint_status"));
				complaints.add(new Complaint(rs.getInt("complaint_id"),"","",rs.getString("complaint_reg_date"),rs.getString("latest_service_date"),rs.getString("complaint_status"),0));
				//System.out.println(rs.getString(1));
			}
			c.close();
			return complaints;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
