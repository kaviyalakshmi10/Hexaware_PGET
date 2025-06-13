package Mavenexample.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App 
{
    public static void main( String[] args )
    {
      ///AbstractApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
     AbstractApplicationContext con= new AnnotationConfigApplicationContext(EmployeeConfig.class);
    	
   	 Employee e = (Employee) con.getBean("e1");
   	  System.out.println(e.toString());
   	  
   	con.registerShutdownHook();
    }
}
