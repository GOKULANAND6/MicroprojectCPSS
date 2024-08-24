package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.InsuranceClaim;

public interface InsuranceClaimService 
{
	public void addClaim(InsuranceClaim claim);
	 
	public List<InsuranceClaim> getallInsuranceClaims();

	public void updateClaim(InsuranceClaim claim);

	public void deleteClaim(int claimId);
	
	public InsuranceClaim findClaimById(int claimId);
	
	public InsuranceClaim findClaimByName(String claimIssue);
}
