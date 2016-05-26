package com.cybage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	//method for obtaining connection with database.
	public Connection connect() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");                                                        //Load driver dynamically
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sample","root","root");   //connection url 
		
		return con;
		
	}

}
