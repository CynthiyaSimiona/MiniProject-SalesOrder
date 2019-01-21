package com.MiniProject.SalesOrderApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MiniProject.SalesOrderApp.Model.SalesOrder;


@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder,String> {
	
	List<SalesOrder> findAll();
	
	void deleteById(String id);
	
	Optional<SalesOrder> findById(String id);

}