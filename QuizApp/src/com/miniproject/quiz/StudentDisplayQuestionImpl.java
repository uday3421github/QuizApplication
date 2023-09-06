package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDisplayQuestionImpl implements StudentDisplayQuestion {
	static int marks=0;

	@Override
	public void displayQuestion() {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			con=connectionMain.getConnection();
			ps=con.prepareStatement("select que_name,opt1,opt2,opt3,opt4,ans from addquestion");
			rs=ps.executeQuery();
			while(rs.next())
			{			

				//System.out.println("Question  : "+rs.getInt(0));
				System.out.println(rs.getString(1));
				System.out.println("a. "+rs.getString(2));
				System.out.println("b. "+rs.getString(3));
				System.out.println("c. "+rs.getString(4));
				System.out.println("d. "+rs.getString(5));
				System.out.println("Enter the answer");
				Scanner scanner=new Scanner(System.in);
				String answer=scanner.nextLine();
				if(answer.equals(rs.getString(6)))
				{
					marks=marks+1;
				}
				
				System.out.println("Marks = "+marks);
			}
			//Statement stmt=con.createStatement();
			//stmt.execute("insert into studentregistration(score)values("+marks+")");
			//System.out.println("Marks updated");
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
