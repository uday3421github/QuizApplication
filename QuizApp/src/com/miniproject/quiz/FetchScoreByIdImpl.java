package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchScoreByIdImpl implements FetchScoreById {

	@Override
	public void fetchScoreUsingId() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		Scanner scanner=new Scanner(System.in);
		int studentId=scanner.nextInt();
		passId(studentId);
		
	}

	private void passId(int studentId) {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=connectionMain.getConnection();
			ps=con.prepareStatement("select * from studentregistration");
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				int studId=rs.getInt("stud_id");
				  if(studentId==studId)
					{
						System.out.println("Score="+rs.getInt("score"));
					}
					else
					{
						System.out.println("Student id does not exist");
					}		 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
