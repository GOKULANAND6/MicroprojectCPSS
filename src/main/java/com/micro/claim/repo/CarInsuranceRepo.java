package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.CarInsurance;

public interface CarInsuranceRepo 
{
	public void save(CarInsurance carinsurance);

	public List<CarInsurance> findAllCarInsurances();

	public void update(CarInsurance carinsurance);

	public void deleteById(int policyId);
	
	public CarInsurance findById(int policyId);
	
	public CarInsurance findByName(String policyName);
}
