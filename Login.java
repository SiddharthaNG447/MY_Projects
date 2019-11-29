package Facebook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String var=request.getParameter("ver");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
	Connection	 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/facbook","root","root");  
			
	PreparedStatement ps=con.prepareStatement("select password from first where password=?");
	
		ps.setString(1, var);
	     ResultSet rs=ps.executeQuery();
			rs.absolute(1);
	      if(var.equals(rs.getString(1)))
	      {
	    	  System.out.println("successfully logged in");
	    	  response.sendRedirect("http://www.javatpoint.com"); 
	  		
				
	      }
		}catch(Exception e) {System.out.println(e);}
		
		
		
	}

}
