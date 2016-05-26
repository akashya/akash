

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cybage.ConnectionDB;


public class logFilter implements Filter {

  static Connection con = null; 
  PrintWriter pw=null;
 
	public void destroy() {
	
		pw.close();
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		   
		   String name=(String)((HttpServletRequest)request).getSession().getAttribute("usersession");
          
           
		 
           try 
           {
			  ConnectionDB cd = new ConnectionDB();
			  con=cd.connect();
			  String time=(new Date()).toString();
			  String Query = "insert into  loginfo(username,time)values('"+name+"','"+time+"')";  
			
			  Statement st = con.createStatement();
			  boolean i=st.execute(Query);
			} 
            catch (ClassNotFoundException | SQLException e)
            {
	          e.printStackTrace();
		    }
          
            chain.doFilter(request, response);
           
            
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
