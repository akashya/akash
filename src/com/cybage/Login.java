package com.cybage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login 
{
	static Connection con = null; 
	
	public String Validate(String uname,String pass) throws Exception
	{
		String status=null;
		ConnectionDB cd = new ConnectionDB();
		con = cd.connect();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from logintable where username='"+uname+"' && password='"+pass+"'");
		System.out.println(uname+""+pass);
		if(rs.next()) 
		{
            
			if(rs.getString(2).equals(uname) && rs.getString(3).equals(pass))
			{
				
				if(rs.getString(4).equals("user"))
				{
					
					status="user";
					
			    }
				else
				{  
					
					status="admin";
				}
			}
			else
		    {
			       // status="wrong";
		    }
		
		}
		 else
		 {
		
			  status="wrong";
		 }
		
		
		 return status;
	}

}
