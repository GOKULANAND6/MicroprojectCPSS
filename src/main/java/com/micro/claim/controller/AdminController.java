package com.micro.claim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.claim.model.AdminSignup;
import com.micro.claim.service.AdminServiceImplementation;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController 
{
	AdminServiceImplementation service;

	public AdminController(AdminServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public  String insertAdmin(@RequestBody AdminSignup admin)
	{
	String msg = "";
	try {
	service.addAdmin(admin);
	msg = "Successfully Added";
	}
	catch (Exception e) {
	msg = "Failed to Add";
	}
	return msg;
	}

	@GetMapping("/all")
	public List<AdminSignup> readAllAdmins()
	{
	return service.getallAdmins();
	}

	@PutMapping
	public  String updateAdmin(@RequestBody AdminSignup admin)
	{
	String msg = "";
	try {
	service.updateAdmin(admin);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{adminId}")
	public String deleteAdminbyId(@PathVariable("adminId") int adminId)
	{
	String msg = "";
	try {
	service.deleteAdmin(adminId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{adminId}")
	public AdminSignup findAdmin(@PathVariable("adminId") int adminId)
	{
			return service.findAdminById(adminId);
	}
}
