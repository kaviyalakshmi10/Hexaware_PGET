package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.JpaRepo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo Respo;

    public Customer dsaveD(Customer c) {
        return Respo.save(c);
    }

    public List<Customer> getData1() {
        return Respo.findAllCustomer();
    }

    public String deleteById(int ac) {
        Customer c = Respo.findById(ac).orElse(null);
        if (c != null) {
            Respo.deleteById(ac);
            return "Customer with account " + ac + " deleted.";
        } else {
            return "Customer not found.";
        }
    }

    public Customer deposit(int actno, double amt) {
        Customer c = Respo.findById(actno).orElse(null);
        if (c != null) {
            double newBal = c.getBalance() + amt;
            c.setBalance(newBal);
            return Respo.save(c);
        }
        return null;
    }

    public Customer FindByActJPQL(int ac) {
        return Respo.findByActJPQL(ac);
    }

    public int UpdateBal(int ac, double bal) {
        return Respo.deposit1(ac, bal);
    }
    
    public String withdrawAmount(int actno, double amt) {
	    Customer c = Respo.findById(actno).orElse(null);

	    if (c == null) {
	        return "Account not found!";
	    }

	    if (c.getBalance() - amt < 1000) {
	        return "Insufficient balance. Minimum ₹1000 must be maintained.";
	    }

	    Respo.withdraw(actno, amt);
	    return "Withdrawal successful. New balance: ₹" + (c.getBalance()-amt);
	}
    
    public Customer getSearchName(String n) {
		return Respo.findByNameJPQL(n);
	}
    public String DeleteAct(int ac) {
        return Respo.DeleteAc(ac) + " Account deleted";
    }


}