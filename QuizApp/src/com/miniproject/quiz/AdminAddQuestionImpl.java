package com.miniproject.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAddQuestionImpl implements AdminAddQuestion {

	@Override
	public void addQuestion() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the question");
		String question=scanner.nextLine();
		System.out.println("a. ");
		String option1=scanner.nextLine();
		System.out.println("b. ");
		String option2=scanner.nextLine();
		System.out.println("c. ");
		String option3=scanner.nextLine();
		System.out.println("d. ");
		String option4=scanner.nextLine();
		System.out.println("Enter the correct answer ");
		String answer=scanner.nextLine();
		
		passAddQuestionDetails(question,option1,option2,option3,option4,answer);
	}

	private void passAddQuestionDetails(String question, String option1, String option2, String option3, String option4,
			String answer) {
		// TODO Auto-generated method stub
		ConnectionMain connectionMain=new ConnectionMain();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=connectionMain.getConnection();
			ps=con.prepareStatement("insert into addquestion(que_name,opt1,opt2,opt3,opt4,ans)values(?,?,?,?,?,?)");
			ps.setString(1, question);
			ps.setString(2, option1);
			ps.setString(3, option2);
			ps.setString(4, option3);
			ps.setString(5, option4);
			ps.setString(6, answer);

			int a=ps.executeUpdate();
			System.out.println("Data added successfully "+a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
