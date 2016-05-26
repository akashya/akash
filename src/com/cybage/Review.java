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


public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null; 
   
    public Review() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
			PrintWriter out=response.getWriter();
			
			try 
			{
				HttpSession session=request.getSession(false);
				String uname= (String) session.getAttribute("usersession");
				
				String bname=request.getParameter("bname") ;
				String review=request.getParameter("review") ;
				
				Book b=new Book();
				int i=b.addReview(bname, uname, review);
				 
				if(i>0)
				 {
				     RequestDispatcher rd=request.getRequestDispatcher("AddReview");
					 rd.include(request, response);
					 out.println(" Book  Review is successfully Added</center>");
				}
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
