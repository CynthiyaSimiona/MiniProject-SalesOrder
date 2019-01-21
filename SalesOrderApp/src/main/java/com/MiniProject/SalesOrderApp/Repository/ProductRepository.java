package com.MiniProject.SalesOrderApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MiniProject.SalesOrderApp.Model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,String> {
	
	List<Product> findAll();
	
	Optional<Product> findById(String id);

}