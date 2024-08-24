package com.micro.claim.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.claim.model.CarInsurance;
import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.service.InsuranceClaimServiceImplementation;

@RestController
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:3000")
public class InsuranceClaimController 
{
	InsuranceClaimServiceImplementation service;

	public InsuranceClaimController(InsuranceClaimServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
    public ResponseEntity<String> insertClaim(
            @RequestParam("claimIssue") String claimIssue,
            @RequestParam("carMake") String carMake,
            @RequestParam("carName") String carName,
            @RequestParam("carModel") String carModel,
            @RequestParam("carYear") String carYear,
            @RequestParam("carBuyingdate") String carBuyingdate,
            @RequestParam("carNumber") String carNumber,
            @RequestParam("claimStatus") String claimStatus,
            @RequestParam("vehicleInvoice") MultipartFile vehicleInvoice,
            @RequestParam("presentImage") MultipartFile presentImage,
            @RequestParam("carinsurance") String carinsuranceJson) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CarInsurance carInsurance = objectMapper.readValue(carinsuranceJson, CarInsurance.class);

            InsuranceClaim insuranceClaim = new InsuranceClaim();
            insuranceClaim.setClaimIssue(claimIssue);
            insuranceClaim.setCarMake(carMake);
            insuranceClaim.setCarName(carName);
            insuranceClaim.setCarModel(carModel);
            insuranceClaim.setCarYear(carYear);
            insuranceClaim.setCarBuyingdate(carBuyingdate);
            insuranceClaim.setCarNumber(carNumber);
            insuranceClaim.setClaimStatus(claimStatus);
            insuranceClaim.setCarinsurance(carInsurance);

            if (vehicleInvoice != null && !vehicleInvoice.isEmpty()) {
                insuranceClaim.setVehicleInvoice(vehicleInvoice.getBytes());
            }
            if (presentImage != null && !presentImage.isEmpty()) {
                insuranceClaim.setPresentImage(presentImage.getBytes());
            }

            service.addClaim(insuranceClaim);

            return ResponseEntity.ok("Claim submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing claim.");
        }
    }
	

	@GetMapping("/all")
	public List<InsuranceClaim> readAllInsuranceClaims()
	{
	return service.getallInsuranceClaims();
	}

	@PutMapping
	public  String updateClaim(@RequestBody InsuranceClaim claim)
	{
	String msg = "";
	try {
	service.updateClaim(claim);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{claimId}")
	public String deleteClaimbyId(@PathVariable("claimId") int claimId)
	{
	String msg = "";
	try {
	service.deleteClaim(claimId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{claimId}")
	public InsuranceClaim findClaim(@PathVariable("claimId") int claimId)
	{
			return service.findClaimById(claimId);
	}	
}
