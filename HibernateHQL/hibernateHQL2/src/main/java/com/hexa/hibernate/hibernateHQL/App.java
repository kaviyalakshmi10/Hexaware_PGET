package com.hexa.hibernate.hibernateHQL;

import service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
 	
	StudentService  service = new StudentService();
	//service.saveService();
	//service.removeData();
	//service.updateStudent();
	//service.searchStudent();
	//service.showAllStudents();
	//service.showAll();
	//service.searchByName();
	service.searchName();
	//service.searchByNameMarks();
	//service.removeByRollHQL();
    //service.searchByGreaterMarks();
	//service.updateNameByRollService();
	//service.removeByRollHL();
        System.out.println( "Hello World!" );
    }
}
