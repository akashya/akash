package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null; 
   
    public Validate() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			HttpSession session;
			String username=request.getParameter("uname");
			String Password=request.getParameter("pass");
			PrintWriter out=response.getWriter();
			
			Cookie ck1=new Cookie("visitors", username);                          //Setting cookie
			ck1.setMaxAge(24*60*60);
			response.addCookie(ck1);
			
			session=request.getSession(true);                                    //setting session
			session.setAttribute("usersession", username);
			
			Login lg=new Login();
			String Status=lg.Validate(username, Password);
			System.out.println(Status);
			if(Status.equals("user"))
			{
				response.sendRedirect("UserHome");
			}
			else if (Status.equals("admin")) 
			{
				
				response.sendRedirect("AdminHome");
			}
			else
			{
			   RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			   rd.include(request, response);
			   out.append("<script>alert('Invalid User')</script>");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
