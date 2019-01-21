package com.MiniProject.SalesOrderApp.Model;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="salesorder")

public class SalesOrder {
	
	@Id
	private String orderid;
	
	private int quantity;
	
	private String totalprice;
	
	@ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="custid",referencedColumnName="id")
	
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pcode",referencedColumnName="pcode")
	
	private Product product;
	
	public SalesOrder( ) { }

	public SalesOrder(String orderid2, Customer customer,Product product, int quantity2, String totalprice2) {
		this.setOrderid(orderid2);
		this.setQuantity(quantity2);
		this.setTotalprice(totalprice2);
		this.setCustomer(customer);
		this.setProduct(product);
		
	}

	
	public String getOrderid() {
		
		return orderid;
	}

	public void setOrderid(String orderid) {
		
		this.orderid = orderid;
	}

	public int getQuantity() {
		
		return quantity;
	}

	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}

	public String getTotalprice() {
		
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		
		this.totalprice = totalprice;
	}

	
	public Customer getCustomer() {
		
		return customer;
	}

	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}

	public Product getProduct() {
		
		return product;
	}

	public void setProduct(Product product) {
		
		this.product = product;
	}
	
	

}