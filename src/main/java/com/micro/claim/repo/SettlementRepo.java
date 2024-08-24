package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.Settlement;

public interface SettlementRepo 
{	
	public void save(Settlement settlement);

	public List<Settlement> findAllSettlements();
	
	public void update(Settlement settlement);
	
	public void deleteById(int settlementId);
	
	public Settlement findById(int settlementId);
	
}