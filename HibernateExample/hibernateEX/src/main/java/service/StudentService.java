package service;

import java.util.Scanner;

import dao.Studentdao;
import model.Student;

public class StudentService {
	
	Student s;
	Studentdao dao;
	Scanner sc;
	
	public StudentService() 
	{//Constructor
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


			
	 

	    }


