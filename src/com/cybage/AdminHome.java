package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminHome() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
           PrintWriter out=response.getWriter();
           
                
           HttpSession session=request.getSession();
     	   String user =(String) session.getAttribute("usersession");
            
     	   
     	   ServletContext context=request.getServletContext();
     	   int count=0;
		   try 
		   {
			      count = (int) context.getAttribute("usercount");
		   } catch (Exception e1)
		   {
			
			e1.printStackTrace();
		   }
                 
             if(!session.isNew())
             {
				try {
					   
           
					out.println("<body bgcolor='silver'>");
					out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
					
					
					out.println("<h4>Welcome : "+user+"</h4>");
					out.println("</br></br>");
					
					out.println("online people : "+count);
				    
					Cookie ck1[]=request.getCookies();
					out.println("</br>");
					out.println("</br>");
					out.println("No of visitors :"+ck1.length);
					out.println("</br>");
					out.println("</br>");
					
					
					
					out.println("<a href='InsertBook'>Add</a>");
					out.println("<a href='Delete'>Delete</a>");
					
						
				
				} catch (Exception e) {
					
					e.printStackTrace();
				}
             }
             else
             {
            	 response.sendRedirect("Home.html");
             }
             }


	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
