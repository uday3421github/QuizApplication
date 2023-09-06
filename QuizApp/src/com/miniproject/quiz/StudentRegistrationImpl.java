package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistrationImpl implements StudentRegistration {

	@Override
	public void getRegistrationDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the first name");
		String firstName=scanner.next();
		System.out.println("Enter the last name");
		String lastName=scanner.next();
		System.out.println("Enter the username");
		String userName=scanner.next();
		System.out.println("Enter the password");
		String password=scanner.next();
		System.out.println("Enter the city");
		String city=scanner.next();
		System.out.println("Enter the email id");
		String email=scanner.next();
		System.out.println("Enter the mobile number");
		String mobileNumber=scanner.next();
		passRegistrationDetails(firstName,lastName,userName,password,city,email,mobileNumber);
	}

	private void passRegistrationDetails(String firstName, String lastName, String userName, String password, String city,
			String email, String mobileNumber) {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=connectionMain.getConnection();
			ps=con.prepareStatement("insert into studentregistration(stud_firstname,stud_lastname,stud_username,"
					+ "stud_password,stud_city,stud_email,stud_phone)values(?,?,?,?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, email);
			ps.setString(7, mobileNumber);
			int a=ps.executeUpdate();
			System.out.println("Data inserted successfully"+a);
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
