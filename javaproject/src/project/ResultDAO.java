package project;

import java.util.List;

import project.Result;


public interface ResultDAO {
	
	public void addStudent(Result r);
	public void deleteStudent(int id);
	public void searchStudent(String fname);
	
	public void FailedStudent();
	 public List<Result> listAllStudents();
}
