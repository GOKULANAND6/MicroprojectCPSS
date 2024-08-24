package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.AdminSignup;

public interface AdminRepo 
{
	public void save(AdminSignup admin);

	public List<AdminSignup> findAllAdminSignups();

	public void update(AdminSignup admin);

	public void deleteById(int adminId);
	
	public AdminSignup findById(int adminId);
	
	public AdminSignup findByName(String adminName);
}
