package com.MiniProject.SalesOrderApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MiniProject.SalesOrderApp.Model.Customer;




@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	List<Customer> findAll();
	
	Customer findById(int id);
	
	

}