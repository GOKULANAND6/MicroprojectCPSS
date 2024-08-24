package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.CustomerSignup;

public interface CustomerService 
{
	public void addCustomer(CustomerSignup customer);
	 
	public List<CustomerSignup> getallCustomers();

	public void updateCustomer(CustomerSignup customer);

	public void deleteCustomer(int customerId);
	
	public CustomerSignup findCustomerById(int customerId);
	
	public CustomerSignup findCustomerByName(String customerName);
}
