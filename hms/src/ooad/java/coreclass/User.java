package ooad.java.coreclass;

public interface User {
	String name = "";					//user's name
	String username="";				//user's string used for login
	String password="";				//password for
	
	
	public void UpdatePassword(String password);
	public void UpdateName(String name);
	public boolean Authenticate(String username,String password);
}
