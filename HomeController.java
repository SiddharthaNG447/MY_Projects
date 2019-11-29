package com.sample.des;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.sample.des.model.firstmd;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, firstmd model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		
		return "ready";
	}

	@RequestMapping(value = "/click", method = RequestMethod.GET)
	public String home2(Locale locale, @ModelAttribute("reg") firstmd model) {

		return "home";
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ModelAndView  getUsers(ModelAndView model) {
		ArrayList<firstmd> list = new ArrayList<firstmd>();
		ModelAndView map=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springs", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from firstsp");
			map = new ModelAndView("list");
			 
					
			while(res.next()) {
				firstmd fd=new firstmd();
				fd.setNm(res.getString(1));
				fd.setGender(res.getString(2));
				list.add(fd);
				
			}
				
		} catch (Exception e ) {
			System.out.println(e);
		}
		map.addObject("lists", list);


		return map;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String home1(@ModelAttribute("reg") firstmd model) {

		// System.out.println(model.getNm());
		// System.out.println(model.getGender());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springs", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into firstsp values(?,?)");

			ps.setString(1, model.getNm());

			ps.setString(2, model.getGender());
			int i = ps.executeUpdate();
			System.out.println("your Registration wsa successfully completed");

		} catch (Exception e) {
			System.out.println(e);
		}

		return "done";
	}

	@RequestMapping(value = "/returnhome", method = RequestMethod.GET)
	public String returntohome(Locale locale, @ModelAttribute("reg") firstmd model) {

		return "ready";

	}

	@RequestMapping(value = "/rereg", method = RequestMethod.GET)
	public String regagain(Locale locale, @ModelAttribute("reg") firstmd model) {

		return "home";
	}

	@RequestMapping(value = "/listhome", method = RequestMethod.GET)
	public String listhome(Locale locale, @ModelAttribute("reg") firstmd model) {

		return "ready";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET )
	public ModelAndView editOrDeleteEmployee(ModelAndView model ) {

		ArrayList<firstmd> list2 = new ArrayList<firstmd>();
		ModelAndView map2=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springs", "root", "root");
			
			Statement stmt=con.createStatement();  
			  
		//	stmt.executeUpdate("insert into emp765 values(33,'Irfan',50000)");  
		//	int result=stmt.executeUpdate("update emp765 set name='Vimal',salary=10000 where id=33");  
			int result1=stmt.executeUpdate("update firstsp set name='office' where gender='custom'");  
			ResultSet res = stmt.executeQuery("select * from firstsp");
			map2 = new ModelAndView("list");
		
			while(res.next()) {
				firstmd fd=new firstmd();
				fd.setNm(res.getString(1));
			   fd.setGender(res.getString(2));
				list2.add(fd);
			}
			
		} catch (Exception e ) {
			System.out.println(e);
		}
		map2.addObject("lists", list2);
		
		
		
		
		return map2;
	}
	
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public ModelAndView checkOut(ModelAndView model, @RequestParam(value = "selectedrecord", required = false) String nm) {
		ArrayList<firstmd> list5 = new ArrayList<firstmd>();
		ModelAndView map5=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springs", "root", "root");
			
			Statement stmt=con.createStatement();  
			int result=stmt.executeUpdate("delete from firstsp where name='"+nm+"'"); 
			
			ResultSet res = stmt.executeQuery("select * from firstsp");
		     
			System.out.println(result+" records affected");  
			 
			map5 = new ModelAndView("list");
			
			while(res.next()) {
				firstmd fd=new firstmd();
				fd.setNm(res.getString(1));
				fd.setGender(res.getString(2));
				list5.add(fd);
				
			}
		}catch(Exception e) {System.out.println(e);}
		

		map5.addObject("lists", list5);
	     
	    

	    return map5;

	}
	
	
}
