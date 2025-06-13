package dao;

import model.Student;

public interface DaoStudentI {
	
	void saveData(Student s);
	void removeByRoll(int rno);
	void updateData(int rno, String name, double marks);
	Student searchByRoll(int rno);
	void ShowData();
	void ShowDataName();
	void removeByRol(int rollno);
	void searchHQLName(String snm);
	void serachHQLNameMarks(String name, double marks);
	void searchMarksGreaterThan(double Marks);
	void removeByRollNo(int rollno);
	void updateByRollNo(int rollno,String name);
	void searchname(String snm);
	
	

}
