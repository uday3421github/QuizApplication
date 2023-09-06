package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAllStudentScoreImpl implements DisplayAllStudentScore{

	@Override
	public void getAllScoreDetails() {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=connectionMain.getConnection();
			ps=con.prepareStatement("select * from studentregistration order by score");
			rs=ps.executeQuery();
			while(rs.next())
			{
				String firstname=rs.getString("stud_firstname");
				System.out.println("First Name ="+firstname);
				String lastname=rs.getString("stud_lastname");
				System.out.println("Last Name ="+lastname);
				int score=rs.getInt("score");
				System.out.println("Score = "+score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
