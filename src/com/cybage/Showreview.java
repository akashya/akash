package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Showreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;   
    
    public Showreview() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   ConnectionDB cd = new ConnectionDB();
		  
		   HttpSession session=request.getSession();
		   String user =(String) session.getAttribute("usersession");
		   
           PrintWriter out=response.getWriter();
           String bname=request.getParameter("bname");
           
           if(!session.isNew())
      	   {
               try 
               {
        	     con = cd.connect();
        	     String Query = "select * from bookreview where bname='"+bname+"'";                 // delete Query
                 Statement st=con.createStatement();
                 ResultSet rs1 = st.executeQuery(Query);
				 
				 out.println("<body bgcolor='silver'>");
				 out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
				 out.println("<center>");
				 out.println("<h1>WELOCME TO CYBAGENET</h1>");
				 out.println("<h4>Book Name : "+bname+"</br></br>");
				 out.println("<h3>REVIEW</h3></br></br>");
				 out.println("<table  border='2'>");
				 
				 while (rs1.next()) {
					 out.println("<tr><td>");
					 out.println(rs1.getString(4));
					 out.println("</td><td>By : "+rs1.getString(3));
					 out.println("</td></tr>");
				}
				 out.println("</table></br>");
				 out.println("<a href='UserHome'>Back to Home</a>");
				 out.println("</center>");
				
				
				
				 out.println("</div>");	
        	
		     } 
             catch (SQLException | ClassNotFoundException e) 
             {
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
