package com.MiniProject.SalesOrderApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.SalesOrderApp.Model.Customer;
import com.MiniProject.SalesOrderApp.Model.Product;
import com.MiniProject.SalesOrderApp.Model.SalesOrder;
import com.MiniProject.SalesOrderApp.Repository.CustomerRepository;
import com.MiniProject.SalesOrderApp.Repository.ProductRepository;
import com.MiniProject.SalesOrderApp.Repository.SalesOrderRepository;

@RestController
public class SalesController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@GetMapping("/hellosales")
	public String Hello() {
		
		return "Hello World";
	}
	
	@GetMapping("/hello")
	public String HelloMe() {
		
		return "Hello Me";
	}
	
	@GetMapping("/customer/getall")
	public List<Customer> GetAllCustomers(){
		
		return customerRepository.findAll();
	
}
	
	@GetMapping("/sales/getall")
	public List<SalesOrder> GetAllOrders(){
		
		return salesOrderRepository.findAll();

}
	
	@GetMapping("/product/getall")
	public List<Product> GetAllProducts(){
		
		return productRepository.findAll();
}
	
	@GetMapping("/findsales/{id}")
	public Optional<SalesOrder> Search(@PathVariable(value="id") String id) {
		return salesOrderRepository.findById(id);
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody SalesOrder order)
	{
	String orderid=order.getOrderid();
	
	if(salesOrderRepository.existsById(orderid))
	
	return "Order\t"+orderid+"\talready Exist";
	else
	{
	Customer customer=order.getCustomer();
	Product product=order.getProduct();
	String TotalPrice=order.getTotalprice();
	int cid=customer.getId();
	String pcode=product.getPcode();
	int quantity=order.getQuantity();
	if(customerRepository.existsById(cid)&&productRepository.existsById(pcode))
	{
	salesOrderRepository.save(new SalesOrder(orderid,customer,product,quantity,TotalPrice));
	return "row insertion successful";

	}
	else
	{
	return "Cid and Pid doesn't exist";
	}
	}


	}
    
	
	@DeleteMapping("/order/delete/{id}")
	public String Delete(@PathVariable(value="id") String id) throws EmptyResultDataAccessException {
		
		try {
		salesOrderRepository.deleteById(id);
		return "Order with id\t"+id+"\tdeleted succcessfully";
		}
		catch(Exception e) {
			return "Order with id\t"+id+"\tnot found";
		}
	}
		
    @PutMapping("/update")
    public Object Update(@RequestBody SalesOrder body) {
    	
    	String id=body.getOrderid();
    	if( salesOrderRepository.existsById(id)) {
//    		body.setQuantity(body.getQuantity());
//    		
//    		body.setTotalprice(body.getTotalprice());
//    		
//    		body.setCustomer(body.getCustomer());
//    		
//    		body.setProduct(body.getProduct());
   		
    		return salesOrderRepository.save(body);
    	
    	
   }
    	
    	else
    		
    		return "Order with id\t" +id+"\t cannot be found";
	
	
	
}
    //test
    
}
