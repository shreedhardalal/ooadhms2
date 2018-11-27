package ooad.java.coreclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import ooad.java.database.DatabaseHandler;

public class Complaint {
	public int id=0;
	public String comp=null;
	public String comp_class=null;
	public String comp_reg_date=null;
	public String comp_serv_date=null;
	public String comp_status=null;
	public int feedback=0;
	static DatabaseHandler db = new DatabaseHandler();
	public Complaint() {
		
	}
	public Complaint(int id) {
		
	}
	public Complaint(int id,String comp,String comp_class,String comp_reg_date,String comp_serv_date,String comp_status,int feedback) {
		this.id=id;
		this.comp=comp;
		this.comp_class = comp_class;
		this.comp_reg_date=comp_reg_date;
		this.comp_serv_date=comp_serv_date;
		this.comp_status=comp_status;
		this.feedback=feedback;
	}
	
	public static void main(String args[]) throws ClassNotFoundException {
		
	}
	
	public boolean addComplaint(String user,String Complaint,String Class) throws ClassNotFoundException {
		return db.AddComplaint(user,Complaint,Class);
	}
	public boolean addComplaint(String user,String Complaint) throws ClassNotFoundException {
		return db.AddComplaint(user,Complaint,ClassifyComplaint(Complaint));
	}
	//return if update successfully
	public static boolean UpdateStatus(int Complaint,String Status) throws ClassNotFoundException {
		return DatabaseHandler.UpdateComplaintStatus(Complaint, Status);
	}
	public ArrayList<Complaint> GetWorkerFeedback() throws ClassNotFoundException{
		DatabaseHandler db;
		ArrayList<Complaint> com = DatabaseHandler.GetWorkerFeedback();
		return com;	
	}
	public boolean GiveFeedback(int Complaint,int Feedback) {
		return false;
	}
	public ArrayList<Complaint> GetComplaints(String username) throws ClassNotFoundException {
		DatabaseHandler db;
		ArrayList<Complaint> com = DatabaseHandler.GetStudentComplaint("20180283");
		return com;		
	}
	public void ApproveComplaint(String name,String Complaint) {
		
	}
	public void ServiceComplaint(String name,String Complaint,Date date) {
		
	}
	public String ClassifyComplaint(String Complaint) {
		String input_string = Complaint; //= inp.nextLine();
		Process p;
		try {
			p = Runtime.getRuntime().exec("python /home/shreedhar/getclass.py "+input_string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Default";
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String ret;
		try {
			ret = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return "Default";
		}
		return ret;
	}
	
}
