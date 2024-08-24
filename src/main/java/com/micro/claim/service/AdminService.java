package com.micro.claim.service;

import java.util.List;

import com.micro.claim.model.AdminSignup;

public interface AdminService 
{
	public void addAdmin(AdminSignup admin);
	 
	public List<AdminSignup> getallAdmins();

	public void updateAdmin(AdminSignup admin);

	public void deleteAdmin(int adminId);
	
	public AdminSignup findAdminById(int adminId);
	
	public AdminSignup findAdminByName(String adminName);
}
