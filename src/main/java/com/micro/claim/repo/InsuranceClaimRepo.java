package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.InsuranceClaim;

public interface InsuranceClaimRepo 
{
	public void save(InsuranceClaim claim);

	public List<InsuranceClaim> findAllInsuranceClaims();

	public void update(InsuranceClaim claim);

	public void deleteById(int claimId);
	
	public InsuranceClaim findById(int claimId);
	
	public InsuranceClaim findByName(String claimIssue);
}
