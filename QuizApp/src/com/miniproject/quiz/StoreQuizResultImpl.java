package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreQuizResultImpl implements StoreQuizResult{
	
	@Override
	public void getScore() {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		StudentDisplayQuestionImpl studentDisplayQuestionImpl=new StudentDisplayQuestionImpl();
		int mark=studentDisplayQuestionImpl.marks;
		//System.out.println("marks"+mark);
		StudentLoginImpl studentLoginImpl=new StudentLoginImpl();
		int studentId=studentLoginImpl.id;
		//System.out.println("Id="+studentId);
		try {
			con=connectionMain.getConnection();
			//Statement stmt=con.createStatement();
		//	stmt.execute("insert into studentregistration(score)values("+mark+")");
		//ps=con.prepareStatement("update table studentregistration set score="+mark+"where stud_id="+studentId+")");
		ps=con.prepareStatement("update studentregistration set score=? where stud_id=?");
		ps.setInt(1, mark);
		ps.setInt(2, studentId);
		int a=ps.executeUpdate();
		System.out.println("Store the quiz result into database with score"+a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Marks updated");
	}

}
