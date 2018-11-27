package ooad.java.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ooad.java.coreclass.*;
/**
 * Servlet implementation class ClassifyComplaint
 */
@WebServlet("/ClassifyComplaint")
public class ClassifyComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassifyComplaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String complaint = "";
		complaint =	request.getParameter("complaint");
		String user = request.getParameter("user");
		String ClassifiedClass = "Default";
		if(complaint ==null || complaint == "") {
			response.sendRedirect("StudentHome.jsp");
			System.out.println("no complaint found");
		}
		else {
			Complaint com  = new Complaint();
			ClassifiedClass = com.ClassifyComplaint(complaint);
			System.out.println(ClassifiedClass);
			try {
				response.sendRedirect("StudentHome.jsp");
				com.addComplaint(user, complaint);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.sendRedirect("StudentHome.jsp");
		}
	}

}
