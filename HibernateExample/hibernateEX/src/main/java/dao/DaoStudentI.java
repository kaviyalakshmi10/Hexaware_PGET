package dao;

import model.Student;

public interface DaoStudentI {
	
	void saveData(Student s);
	void removeByRoll(int rno);
	void updateData(int rno, String name, double marks);
	Student searchByRoll(int rno);
	void ShowData();
	

}
