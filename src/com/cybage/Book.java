package com.cybage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Book {

	static Connection con = null; 
	public int add(String bname,String author,double price) throws Exception, Exception
	{
		
		 ConnectionDB cd = new ConnectionDB();
		 con = cd.connect();
		 
		 String Query = "insert into book(bname,author,price) values (?,?,?)";
		 PreparedStatement st = con.prepareStatement(Query);

			
		  st.setString(1, bname);
		  st.setString(2,author );
		  st.setDouble(3, price);

	     int i = st.executeUpdate();
		 
		 return i;
		
	}
	
	
	public int delete( String bname) throws ClassNotFoundException, SQLException
	{
		 ConnectionDB cd = new ConnectionDB();
		 con = cd.connect();
		 
		 String Query = "delete from book where bname=? ";                 // delete Query
		 PreparedStatement st = con.prepareStatement(Query);
		 st.setString(1,bname);
		 int i = st.executeUpdate();	
			
		 return i;
	}
	
	public boolean search( String bname) throws Exception
	{
		
		 ConnectionDB cd = new ConnectionDB();
		 con = cd.connect();
		 String Query = "select * from book where bname='"+bname+"'";                 // delete Query
         Statement st=con.createStatement();
		 
		 ResultSet rs = st.executeQuery(Query);
		
		 if(rs.next())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		
	}
	
	public int addReview(String bname,String uname,String review) throws Exception
	{
		 ConnectionDB cd = new ConnectionDB();
		 con = cd.connect();
		 
		 String Query = "insert into  bookreview(bname,uname,review) values('"+bname+"','"+uname+"','"+review+"')";  
		 Statement st = con.createStatement();
		 
		 int i=st.executeUpdate(Query);
		 return i;
		
	}
	
}
