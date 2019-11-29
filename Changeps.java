package Facebook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Changeps
 */
@WebServlet("/Changeps")
public class Changeps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changeps() {
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
		
		String nwps=request.getParameter("newpsw");
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/facbook","root","root");

 PreparedStatement stmt=con.prepareStatement("Update first set password=? where firstname=?");
 stmt.setString(1,nwps);//1 specifies the first parameter in the query i.e. name  
 stmt.setString(2,"Nutenki");  

 int i=stmt.executeUpdate();  
 System.out.println(i+" records updated");  
			
		}catch(Exception e) {System.out.println(e);}
		
	
	}

}
