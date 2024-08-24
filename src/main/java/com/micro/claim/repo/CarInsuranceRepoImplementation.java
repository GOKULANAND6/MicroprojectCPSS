package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.CarInsurance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarInsuranceRepoImplementation implements CarInsuranceRepo
{
	EntityManager manager;

	public CarInsuranceRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(CarInsurance carinsurance) 
	{
		manager.persist(carinsurance);
	}

	@Override
	public List<CarInsurance> findAllCarInsurances() 
	{
		String str = "From CarInsurance";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(CarInsurance carinsurance) 
	{
		manager.merge(carinsurance);
	}

	@Override
	public void deleteById(int policyId) 
	{
		CarInsurance carinsurance = manager.find(CarInsurance.class, policyId);
		manager.remove(carinsurance);
	}

	@Override
	public CarInsurance findById(int policyId) 
	{
		return manager.find(CarInsurance.class, policyId);
	}

	@Override
	public CarInsurance findByName(String policyName) 
	{
		String str = "From CarInsurance where policyName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", policyName);
		return (CarInsurance) query.getSingleResult();
	}
}
