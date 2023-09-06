package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
public Connection getConnection() throws SQLException
{
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapplication", "root", "Uday@3421");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
}
