package service;

import java.util.Scanner;

import dao.Studentdao;
import model.Student;

public class StudentService {
	
	Student s;
	Studentdao dao;
	Scanner sc;
	
	public StudentService() 
	{
		s=new Student();
		sc=new Scanner(System.in);
		dao=new Studentdao();
	}
	public void saveService() {
		System.out.print("Enter rollno");
		s.setRollno(sc.nextInt());
		System.out.print("Enter name");
		sc.nextLine();
		s.setName(sc.nextLine());
		System.out.print("Enter Marks");
		s.setMarks(sc.nextDouble());
		
		dao.saveData(s);
		
	}

	    

		public void removeData() {
			int rno;
			System.out.print("enter roll no:");
			rno=sc.nextInt();
			dao.removeByRoll(rno);
		}

		
		public void updateStudent() {
		    System.out.print("Enter rollno to update: ");
		    int rno = sc.nextInt();
		    sc.nextLine(); 
		    System.out.print("Enter new name: ");
		    String name = sc.nextLine();

		    System.out.print("Enter new marks: ");
		    
		    double marks = sc.nextDouble();

		    dao.updateData(rno, name, marks);
		}
		public void searchStudent() {
		    System.out.print("Enter rollno to search: ");
		    int rno = sc.nextInt();
		    dao.searchByRoll(rno);
		}
		public void showAllStudents() {
		    dao.ShowData();
		}
		public void searchByName() {
			System.out.println("enter search name");
			String snm = sc.nextLine();
			dao.searchHQLName(snm);
		}


		public void searchByNameMarks() {
			System.out.println("enter search name");
			String name= sc.nextLine();
			System.out.println("enter marks");
			double marks = sc.nextInt();
			dao.serachHQLNameMarks(name,marks);
			
		} 
	
		public void searchByGreaterMarks() {
		    System.out.print("Enter mark; ");
		    double Marks = sc.nextDouble();
		    dao.searchMarksGreaterThan(Marks);
		}
		
public void removeByRollHQL() {
	System.out.println("enter rollno");
	int rollno=sc.nextInt();
	dao.removeByRollNo(rollno);
}

public void updateNameByRollService() {
    System.out.print("Enter rollno: ");
    int rollno = sc.nextInt();
    sc.nextLine(); 

    System.out.print("Enter new name: ");
    String name = sc.nextLine();

    dao.updateByRollNo(rollno, name);
}

	    }


