package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.Settlement;
import com.micro.claim.repo.SettlementRepo;

@Service
public class SettlementServiceImplementation implements SettlementService
{
	SettlementRepo repo;

	public SettlementServiceImplementation(SettlementRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addSettlement(Settlement settlement) 
	{
		repo.save(settlement);
	}

	@Override
	public List<Settlement> getallSettlements() 
	{
		return repo.findAllSettlements();
	}

	@Override
	public void updateSettlement(Settlement settlement) 
	{
		repo.update(settlement);
	}

	@Override
	public void deleteSettlement(int settlementId) 
	{
		repo.deleteById(settlementId);
	}

	@Override
	public Settlement findSettlementById(int settlementId) 
	{
		return repo.findById(settlementId);
	}
}
