package com.cmdglobal.crud_clean.repository;

import com.cmdglobal.crud_clean.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "CALL showCustomer();", nativeQuery = true)
//    List<Customer> showDataFullinforCustomer();

//    @Query(value ="SELECT * FROM customers;", nativeQuery = true )
//    List<Customer> showDataFullinforCustomer();
}


