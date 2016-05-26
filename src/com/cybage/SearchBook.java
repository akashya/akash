package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
    public SearchBook() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionDB cd = new ConnectionDB();
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String user =(String) session.getAttribute("usersession");
		
		
   if(!session.isNew())
          {
           try {
			 
			
			 String bname=request.getParameter("bookname");  
             Book b=new Book();
			 boolean result=b.search(bname);
			 
			 if(result)
			 {
			  out.println("<body bgcolor='silver'>");
			  out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
			  out.println("<form >");
			  out.println("<h1>WELOCME TO CYBAGENET</h1></br></br>");
			  out.println("<h4>Book Name:"+bname+"</br></br>");
			  
			
			  out.println("</br>");
			  out.println("<a href='ShowDetail?bname="+bname+"'>Show Details</a>");
			  out.println("&nbsp;&nbsp;");
			  out.println("<a href='Showreview?bname="+bname+"'>Show Review</a>");
			  out.println("&nbsp;&nbsp;");
			  out.println("<a href='AddReview?bname="+bname+"'>Add Review</a>");
			  out.println("</form>");
			
			 }
			 else
			 {  
				 RequestDispatcher rd=request.getRequestDispatcher("UserHome");
				 rd.include(request, response);
			     out.println("<center><h4>Book Is Not Available<h4></center>");
				 
			 }
      
         
           
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
