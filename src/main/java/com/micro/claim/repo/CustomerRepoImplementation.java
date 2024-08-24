package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.CustomerSignup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImplementation implements CustomerRepo
{
	EntityManager manager;

	public CustomerRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(CustomerSignup customer) 
	{
		manager.persist(customer);
	}

	@Override
	public List<CustomerSignup> findAllCustomerSignups() 
	{
		String str = "From CustomerSignup";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(CustomerSignup customer) 
	{
		manager.merge(customer);
	}

	@Override
	public void deleteById(int customerId) 
	{
		CustomerSignup customer = manager.find(CustomerSignup.class, customerId);
		manager.remove(customer);
	}

	@Override
	public CustomerSignup findById(int customerId) 
	{
		return manager.find(CustomerSignup.class, customerId);
	}

	@Override
	public CustomerSignup findByName(String customerName) 
	{
		String str = "From CustomerSignup where customerName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", customerName);
		return (CustomerSignup) query.getSingleResult();
	}
}
