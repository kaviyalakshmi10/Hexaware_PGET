package com.example.demo.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

   /* @Query("select c from Customer c")
    List<Customer> findAllCustomer();

    @Query("select c from Customer c where c.actno = :actno")
    Customer findByActJPQL(@Param("actno") int actno);

    @Transactional
    @Modifying
    @Query("update Customer c set c.Balance = c.Balance + :amt where c.actno = :actno")
    int deposit1(@Param("actno") int actno, @Param("amt") double amt);
    
	@Transactional
	@Modifying
	@Query("update Customer  c set c.Balance=c.Balance- :amt  where c.actno=:actno")
	public int withdraw(@Param("actno") int actno, @Param("amt")double amt);
	
	@Query("select c from Customer c where c.name = :name")
	public Customer findByNameJPQL(@Param("name") String name);
	
	   @Transactional
	    @Modifying
	    @Query("delete from Customer c where c.actno = :actno")
	    public int DeleteAc(@Param("actno") int actno);*/


	    @Query(value = "select * from customer", nativeQuery = true)
	    List<Customer> findAllCustomer();

	    @Query(value = "select * from customer where actno = :actno", nativeQuery = true)
	    Customer findByActJPQL(@Param("actno") int actno);

	    @Transactional
	    @Modifying
	    @Query(value = "update customer set Balance = Balance + :amt where actno = :actno", nativeQuery = true)
	    public int deposit1(@Param("actno") int actno, @Param("amt") double amt);
	    
	    @Transactional
	    @Modifying
	    @Query(value = "update customer set Balance = Balance - :amt where actno = :actno", nativeQuery = true)
	    public int withdraw(@Param("actno") int actno, @Param("amt") double amt);
	    
	    @Query(value = "select * from customer where name = :name", nativeQuery = true)
	    public Customer findByNameJPQL(@Param("name") String name);
	    
	    @Transactional
	    @Modifying
	    @Query(value = "delete from customer where actno = :actno", nativeQuery = true)
	    public int DeleteAc(@Param("actno") int actno);
	}

