package project;
import java.util.*;
import project.ResultDAO;
import project.ResultDAOImpl;
import project.Result;
public class App {
public static void main(String[] args) {
	
	int choice=0;
	Scanner sc=new Scanner(System.in);
	ResultDAO dao=new ResultDAOImpl();
	while(choice!=5)
	{
		System.out.println("Student Details");
		System.out.println("1.Add Student");
		System.out.println("2.Delete Student");
		System.out.println("3.Search Student");
		System.out.println("4.Failed Student");
		System.out.println("5.Exit");
		System.out.println("enter your choice");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1:
	{	Result r=acceptStudent();
		dao.addStudent(r);
		break;
	}
	
	case 2:
	{
		System.out.println("enter the roll no of student to be deleted");
		int id =new Scanner(System.in).nextInt();
		dao.deleteStudent(id);
		break;		
	}
	case 3:
	 System.out.println("enter fname to search");
	 String fname=new Scanner(System.in).nextLine();
	 dao.searchStudent(fname);
	 break;
	 
	 
	case 4:
		System.out.println("see fail students name");
		dao.FailedStudent();
		break;
	
	}
	
	}
}

private static Result acceptStudent() {
	
/*	String fname="";
	String lname="";
	String course="";
	String result="";*/
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your first name");
	String fname=sc.nextLine();
	System.out.println("enter your last name");
	String lname=sc.nextLine();
	System.out.println("enter your course");
	String course=sc.nextLine();
	System.out.println("enter your result");
	String result=sc.nextLine();
	
	Result r2=new Result(fname,lname,course,result);
	return r2;
	
	
	
}



}
