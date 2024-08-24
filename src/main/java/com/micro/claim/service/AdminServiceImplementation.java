package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.AdminSignup;
import com.micro.claim.repo.AdminRepo;

@Service
public class AdminServiceImplementation implements AdminService
{
	AdminRepo repo;

	public AdminServiceImplementation(AdminRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addAdmin(AdminSignup admin) 
	{
		repo.save(admin);
	}

	@Override
	public List<AdminSignup> getallAdmins() 
	{
		return repo.findAllAdminSignups();
	}

	@Override
	public void updateAdmin(AdminSignup admin) 
	{
		repo.update(admin);
	}

	@Override
	public void deleteAdmin(int adminId) 
	{
		repo.deleteById(adminId);
	}

	@Override
	public AdminSignup findAdminById(int adminId) 
	{
		return repo.findById(adminId);
	}

	@Override
	public AdminSignup findAdminByName(String adminName) 
	{
		return repo.findByName(adminName);
	}
}
