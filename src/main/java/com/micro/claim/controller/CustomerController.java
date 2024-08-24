package com.micro.claim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.claim.model.CustomerSignup;
import com.micro.claim.service.CustomerServiceImplementation;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController 
{
	CustomerServiceImplementation service;

	public CustomerController(CustomerServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  String insertCustomer(@RequestBody CustomerSignup customer)
	{
	String msg = "";
	try {
	service.addCustomer(customer);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<CustomerSignup> readAllCustomers()
	{
	return service.getallCustomers();
	}

	@PutMapping
	public  String updateCustomer(@RequestBody CustomerSignup customer)
	{
	String msg = "";
	try {
	service.updateCustomer(customer);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{customerId}")
	public String deleteCustomerbyId(@PathVariable("customerId") int customerId)
	{
	String msg = "";
	try {
	service.deleteCustomer(customerId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{customerId}")
	public CustomerSignup findCustomer(@PathVariable("customerId") int customerId)
	{
			return service.findCustomerById(customerId);
	}
}
