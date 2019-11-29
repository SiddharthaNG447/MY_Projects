package Facebook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first=request.getParameter("fname");
		String middle=request.getParameter("mname");
		String last=request.getParameter("lname");
		String gm=request.getParameter("gmail");
		String pps=request.getParameter("pass");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/facbook","root","root"); 
			
  PreparedStatement ps=con.prepareStatement("insert into first values(?,?,?,?,?)");
  
  ps.setString(1, first);
  ps.setString(2, middle);
  ps.setString(3,last);
  ps.setString(4, gm);
  ps.setString(5, pps);
  
  int i=ps.executeUpdate();
  System.out.println(i+"records are inserted");
  System.out.println("your regidtration was successfully completed");
 
  
			
		}catch(Exception e) {System.out.println(e);}	}

}
