package com.MiniProject.SalesOrderApp.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer {
	
	
	public List<SalesOrder> getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(List<SalesOrder> salesOrder) {
		this.salesOrder = salesOrder;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@NotNull
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	//@JsonBackReference
	@JsonIgnore
	@JsonIdentityReference(alwaysAsId = true)
	private List<SalesOrder> salesOrder = new ArrayList<>();


	
	
}