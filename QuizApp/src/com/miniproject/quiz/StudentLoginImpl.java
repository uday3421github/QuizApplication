package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentLoginImpl implements StudentLogin{
	static int id=0;
	//String userName=null;
	//String passWord=null;
	@Override
	public void getLoginDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter username");
		String username=scanner.next();
		System.out.println("Enter password");
		String password=scanner.next();
		passLoginDetails(username,password);
	}

	private void passLoginDetails(String username, String password) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ConnectionMain connectionMain=new ConnectionMain();
		
			try {
			
			con=connectionMain.getConnection();
			ps=con.prepareStatement("select * from studentregistration");
			rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				
				  String userName=rs.getNString("stud_username");
				  String passWord=rs.getNString("stud_password");	
				  if(username.equals(userName)&&password.equals(passWord))
					{
						System.out.println("Login with registered student");
						id=rs.getInt("stud_id");
						System.out.println("Id="+id);
						
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
