package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.CarInsurance;
import com.micro.claim.repo.CarInsuranceRepo;

@Service
public class CarInsuranceServiceImplementation implements CarInsuranceService
{
	CarInsuranceRepo repo;

	public CarInsuranceServiceImplementation(CarInsuranceRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addCarinsurance(CarInsurance carinsurance) 
	{
		repo.save(carinsurance);
	}

	@Override
	public List<CarInsurance> getallCarinsurances() 
	{
		return repo.findAllCarInsurances();
	}

	@Override
	public void updateCarinsurance(CarInsurance carinsurance) 
	{
		repo.update(carinsurance);
	}

	@Override
	public void deleteCarinsurance(int policyId) 
	{
		repo.deleteById(policyId);
	}

	@Override
	public CarInsurance findCarinsuranceById(int policyId) 
	{
		return repo.findById(policyId);
	}

	@Override
	public CarInsurance findCarinsuranceByName(String policyName) 
	{
		return repo.findByName(policyName);
	}
}
