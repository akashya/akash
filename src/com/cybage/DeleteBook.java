package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public DeleteBook() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
	     String user =(String) session.getAttribute("usersession");
		
	
			if(!session.isNew())
			{
				     try {
						String bname = request.getParameter("bname");
						  
						 Book b=new Book();
						 int i=b.delete(bname);
						 
						 if(i>0)
						 {
							 RequestDispatcher rd=request.getRequestDispatcher("Delete");
							 out.println("<center> Books is successfully Deleted </center>");
							 rd.include(request, response);
							 
						 }
						 else
						 {
							 response.sendRedirect("Delete");
						 }
					} catch (Exception e) {
						
						response.sendRedirect("AdminHome");
					} 
					
		   }
		   else
		   {
				response.sendRedirect("Home.html");
		   }
		
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
