package Mavenexample.SpringApi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
    	
   book b = (book) con.getBean("b1");
   	  System.out.println(b.toString());
   	
    }
}
