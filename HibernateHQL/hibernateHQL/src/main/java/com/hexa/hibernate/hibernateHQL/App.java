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
	service.showAllStudents();
	//service.searchByName();
	//service.searchByNameMarks();
	//service.removeByRollHQL();
    //service.searchByGreaterMarks();
	//service.updateNameByRollService();
        System.out.println( "Hello World!" );
    }
}
