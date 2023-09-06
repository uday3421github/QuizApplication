package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayQuizResultImpl implements DisplayQuizResult {

	@Override
	public void displayResult() {
		// TODO Auto-generated method stub
		System.out.println("Enter username");
		Scanner scanner=new Scanner(System.in);
		String username=scanner.next();
		System.out.println("Enter password");
		String password=scanner.next();
		passdisplayResult(username,password);
	}

	private void passdisplayResult(String username, String password) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ConnectionMain connectionMain=new ConnectionMain();
		//String userName = null;
		//String passWord = null;
		StudentLoginImpl studentLoginImpl=new StudentLoginImpl();
		int studentId=studentLoginImpl.id;
			try {
			//String userName=null;
			//String passWord=null;
			con=connectionMain.getConnection();
			ps=con.prepareStatement("select * from studentregistration");
			rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				
				  String userName=rs.getString("stud_username");
				  String passWord=rs.getString("stud_password");	
				  if(username.equals(userName)&&password.equals(passWord))
					{
						System.out.println("Login with registered student");
						//id=rs.getInt("stud_id");
						System.out.println("Score = "+rs.getInt("score"));
					}
					else
					{
						System.out.println("Invalid username or password");
					}		 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}
