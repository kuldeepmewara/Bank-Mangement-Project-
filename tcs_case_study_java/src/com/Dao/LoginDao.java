package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class LoginDao
 {  
	public static boolean validate(String login,String password)
	{  
		boolean status=false;  
		try
		{  
			String JdbcURL = "jdbc:mysql://localhost:3306/tcs?" + "autoReconnect=true&useSSL=false";

			final String USER = "root";
			final String PASS = "root";
			
			Connection conn = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JdbcURL,USER,PASS); 
			      
			PreparedStatement ps=conn.prepareStatement(  
			"select * from userstore where login=? and password=?");  
			ps.setString(1,login);  
			ps.setString(2,password);  
			      
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				status=true;
			else
				status=false;
		  
			          
		}
		catch(Exception e)
		{System.out.println(e);}  
		return status;  
	}  
} 
