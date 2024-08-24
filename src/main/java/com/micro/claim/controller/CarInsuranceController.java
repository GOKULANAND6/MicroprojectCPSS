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

import com.micro.claim.model.CarInsurance;
import com.micro.claim.service.CarInsuranceServiceImplementation;

@RestController
@RequestMapping("/carinsurance")
@CrossOrigin(origins = "http://localhost:3000")
public class CarInsuranceController 
{
	CarInsuranceServiceImplementation service;

	public CarInsuranceController(CarInsuranceServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public CarInsurance insertCarInsurance(@RequestBody CarInsurance carinsurance)
	{
	service.addCarinsurance(carinsurance);
	return carinsurance;
	}

	@GetMapping("/all")
	public List<CarInsurance> readAllCarInsurances()
	{
	return service.getallCarinsurances();
	}

	@PutMapping
	public  String updateCarInsurance(@RequestBody CarInsurance carinsurance)
	{
	String msg = "";
	try {
	service.updateCarinsurance(carinsurance);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{policyId}")
	public String deleteCarInsurancebyId(@PathVariable("policyId") int policyId)
	{
	String msg = "";
	try {
	service.deleteCarinsurance(policyId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{policyId}")
	public CarInsurance findCarInsurance(@PathVariable("policyId") int policyId)
	{
		return service.findCarinsuranceById(policyId);
	}	
}
