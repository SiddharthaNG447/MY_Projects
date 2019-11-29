package com.sample.des;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con1=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/springs","root","root"); 
			
			Statement stmt=con1.createStatement();  
			ResultSet rs=stmt.executeQuery("select *from firstsp");  
			  
			//getting the record of 3rd row  
			rs.next();
			 
			System.out.println(rs.getString(1)+" "+rs.getString(2));  
			con1.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
