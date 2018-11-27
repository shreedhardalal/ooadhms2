package ooad.java.coreclass;

import java.util.Date;

import ooad.java.database.DatabaseHandler;

public class Student implements User {

	public Student(String name, String user_name, String password) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	//return true if raised successfully
	public boolean RaiseComplaint(String name,String complaint) throws ClassNotFoundException {
		Complaint com  = new Complaint();
		com.addComplaint(name, complaint);
		return false;
	}
	//return if update successfully
	public boolean UpdateStatus(String name,int Complaint) {
		return false;
	}
	public boolean RequestOS(String name,Date datein,Date dateout) {
		return false;
	}
	public boolean GiveFeedback(String name,int Complaint,int Feedback) {
		return false;
	}
	public boolean Authenticate(String username, String password) {
		try {
			return DatabaseHandler.AuthenticateUser(username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void UpdatePassword(String password) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void UpdateName(String name) {
		// TODO Auto-generated method stub
		
	}
}
