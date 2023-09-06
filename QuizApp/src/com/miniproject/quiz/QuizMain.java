package com.miniproject.quiz;

import java.util.Scanner;

public class QuizMain {
public static void getChoice()
{
	System.out.println("Welcome To Quiz Based Application");
	System.out.println("User Operation");
	System.out.println("1. Student Registration");
	System.out.println("2. Student Login");
	System.out.println("3. Display the list of questions");
	System.out.println("4. Store quiz result into database");
	System.out.println("5. Display quiz result");
	System.out.println("Admin Operation");
	System.out.println("6. Display all students score as per ascending order");
	System.out.println("7. fetch student score by using id");
	System.out.println("8. Add question with 4 options into database");

	System.out.println("Enter your choice");
	Scanner scanner=new Scanner(System.in);
	int choice=scanner.nextInt();
	
	StudentRegistrationImpl studentRegistrationImpl=new StudentRegistrationImpl();
	StudentLoginImpl studentLoginImpl=new StudentLoginImpl();
	StudentDisplayQuestionImpl studentDisplayQuestionImpl=new StudentDisplayQuestionImpl();
	AdminAddQuestionImpl adminAddQuestionImpl=new AdminAddQuestionImpl();
	StoreQuizResultImpl storeQuizResultImpl=new StoreQuizResultImpl();
	DisplayQuizResultImpl displayQuizResultImpl=new DisplayQuizResultImpl();
	DisplayAllStudentScoreImpl displayAllStudentScoreImpl=new DisplayAllStudentScoreImpl();
	FetchScoreByIdImpl fetchScoreByIdImpl=new FetchScoreByIdImpl();
	
	switch(choice)
	{
	case 1:
		System.out.println("Choice 1");
		studentRegistrationImpl.getRegistrationDetails();
		getChoice();
		break;
	case 2:
		System.out.println("Choice 2");
		studentLoginImpl.getLoginDetails();
		getChoice();
		break;
	case 3:
		System.out.println("Choice 3");
		studentDisplayQuestionImpl.displayQuestion();
		getChoice();
		break;
	case 4:
		System.out.println("Choice 4");
		storeQuizResultImpl.getScore();
		getChoice();
		break;
	case 5:
		System.out.println("Choice 5");
		displayQuizResultImpl.displayResult();
		getChoice();
		break;
	case 6:
		System.out.println("Choice 6");
		displayAllStudentScoreImpl.getAllScoreDetails();
		getChoice();
		break;
	case 7:
		System.out.println("Choice 7");
		fetchScoreByIdImpl.fetchScoreUsingId();
		getChoice();
		break;
	case 8:
		System.out.println("Choice 8");
		adminAddQuestionImpl.addQuestion();
		getChoice();
		break;
	default :
		System.out.println("Wrong Choice");
		
	}

}
public static void main(String[] args) {
	getChoice();
	
}
}
