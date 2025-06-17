package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/saveData")
    public Customer saveData(@RequestBody Customer c) {
        return service.dsaveD(c);
    }

    @GetMapping("/getUsers")
    public List<Customer> getData() {
        return service.getData1();
    }

    @GetMapping("/getdataAc/{ac}")
    public Customer getByAccount(@PathVariable int ac) {
        return service.FindByActJPQL(ac);
    }

    @DeleteMapping("/deleteUserAc/{ac}")
    public String deleteCustomer(@PathVariable int ac) {
        return service.deleteById(ac);
    }

    @PutMapping("/deposit/{actno}/{amt}")
    public String depositAmount(@PathVariable int actno, @PathVariable double amt) {
        Customer u = service.deposit(actno, amt);
        if (u != null) {
            return "Deposit successful. New Balance: " + u.getBalance();
        } else {
            return "Account not found.";
        }
    }

    @PutMapping("/updateBal/{actno}/{amt}")
    public int updateBalance(@PathVariable int actno, @PathVariable double amt) {
        return service.UpdateBal(actno, amt);
    }
    @PutMapping("/withdraw/{actno}/{amt}")
	public String withdraw(@PathVariable("actno") int actno, @PathVariable("amt") double amt) {
	    return service.withdrawAmount(actno,amt);
	}
	@GetMapping("/getdataName/{n}")
    public  Customer getByName(@PathVariable("n") String n)
    {
		   
		  return  service.getSearchName(n);  
		   
    }
	@DeleteMapping("/DeleteAct/{ac}")
	public String deleteByAc(@PathVariable int ac) {
	    return service.DeleteAct(ac);
	}



}