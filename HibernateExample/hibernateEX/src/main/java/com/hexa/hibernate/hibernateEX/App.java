package com.hexa.hibernate.hibernateEX;

import service.StudentService;


public class App 
{
    public static void main( String[] args )
    {
    	
    	StudentService  service = new StudentService();
    	//service.saveService();
    	//service.removeData();
    	//service.updateStudent();
    	//service.searchStudent();
    	service.showAllStudents();
        System.out.println( "Hello World!" );
    }
}