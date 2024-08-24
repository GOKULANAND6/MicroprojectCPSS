package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.CarInsurance;
import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.repo.InsuranceClaimRepo;

public class InsuranceClaimServiceImplementationTestCase {

    @Mock
    private InsuranceClaimRepo repo;

    @InjectMocks
    private InsuranceClaimServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllInsuranceClaims() {
        byte[] vehicleInvoice = {1, 2, 3};
        byte[] presentImage = {4, 5, 6};
        CarInsurance carInsurance = new CarInsurance();
        InsuranceClaim claim1 = new InsuranceClaim(1, "Engine Issue", "Toyota", "Corolla", "XLE", "2020", "2020-01-01", "ABC123", "Pending", vehicleInvoice, presentImage, carInsurance);
        InsuranceClaim claim2 = new InsuranceClaim(2, "Brake Issue", "Honda", "Civic", "Sport", "2019", "2019-01-01", "XYZ789", "Approved", vehicleInvoice, presentImage, carInsurance);

        when(repo.findAllInsuranceClaims()).thenReturn(List.of(claim1, claim2));

        List<InsuranceClaim> claims = service.getallInsuranceClaims();
        
        assertEquals(2, claims.size());
        assertEquals(claim1, claims.get(0));
        assertEquals(claim2, claims.get(1));
    }

    @Test
    public void testUpdateClaim() {
        byte[] vehicleInvoice = {1, 2, 3};
        byte[] presentImage = {4, 5, 6};
        CarInsurance carInsurance = new CarInsurance(); 
        InsuranceClaim claim = new InsuranceClaim(1, "Engine Issue", "Toyota", "Corolla", "XLE", "2020", "2020-01-01", "ABC123", "Pending", vehicleInvoice, presentImage, carInsurance);
        
        service.updateClaim(claim);
        
        verify(repo).update(claim);
    }

    @Test
    public void testDeleteClaim() {
        int claimId = 1;
        service.deleteClaim(claimId);
        verify(repo).deleteById(claimId);
    }

    @Test
    public void testFindClaimById() {
        byte[] vehicleInvoice = {1, 2, 3};
        byte[] presentImage = {4, 5, 6};
        CarInsurance carInsurance = new CarInsurance(); 
        InsuranceClaim claim = new InsuranceClaim(1, "Engine Issue", "Toyota", "Corolla", "XLE", "2020", "2020-01-01", "ABC123", "Pending", vehicleInvoice, presentImage, carInsurance);
        
        when(repo.findById(anyInt())).thenReturn(claim);

        InsuranceClaim foundClaim = service.findClaimById(1);
        
        assertNotNull(foundClaim);
        assertEquals(1, foundClaim.getClaimId());
    }

    @Test
    public void testFindClaimByName() {
        byte[] vehicleInvoice = {1, 2, 3};
        byte[] presentImage = {4, 5, 6};
        CarInsurance carInsurance = new CarInsurance();
        InsuranceClaim claim = new InsuranceClaim(1, "Engine Issue", "Toyota", "Corolla", "XLE", "2020", "2020-01-01", "ABC123", "Pending", vehicleInvoice, presentImage, carInsurance);

        when(repo.findByName(any())).thenReturn(claim);

        InsuranceClaim foundClaim = service.findClaimByName("Engine Issue");
        
        assertNotNull(foundClaim);
        assertEquals("Engine Issue", foundClaim.getClaimIssue());
    }
}
