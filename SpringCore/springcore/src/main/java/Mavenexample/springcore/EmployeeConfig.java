package Mavenexample.springcore;

import java.util.*;

import org.springframework.context.annotation.Bean;

public class EmployeeConfig {
	
	@Bean(name="p1")
    public Project getProject() {
        Project p = new Project();
        p.setpId(202);
        p.setDuration("3 months");
        p.setCost(40000);
        return p;
    }
	
    @Bean(name="e1")
    public Employee getEmployee() {
        Employee e = new Employee();
        e.setEmpId(2);
        e.setName("Lakshmi");
        e.setSalary(80000.0);

        Map<String, String> add = new HashMap<>();
        add.put("home", "Madurai");
        add.put("office", "Coimbatore");

        e.setAddress(add);
        e.setProject(getProject());
        return e;
    }
	
	


}
