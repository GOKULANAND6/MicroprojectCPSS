package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.CustomerSignup;
import com.micro.claim.repo.CustomerRepo;

@Service
public class CustomerServiceImplementation implements CustomerService
{
	CustomerRepo repo;
	
	public CustomerServiceImplementation(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addCustomer(CustomerSignup customer) 
	{
		repo.save(customer);
	}

	@Override
	public List<CustomerSignup> getallCustomers() 
	{
		return repo.findAllCustomerSignups();
	}

	@Override
	public void updateCustomer(CustomerSignup customer) 
	{
		repo.update(customer);
	}

	@Override
	public void deleteCustomer(int customerId) 
	{
		repo.deleteById(customerId);
	}

	@Override
	public CustomerSignup findCustomerById(int customerId) 
	{
		return repo.findById(customerId);
	}

	@Override
	public CustomerSignup findCustomerByName(String customerName) 
	{
		return repo.findByName(customerName);
	}
}
