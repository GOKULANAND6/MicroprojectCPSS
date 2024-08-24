package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.CustomerSignup;
import com.micro.claim.repo.CustomerRepo;

public class CustomerServiceImplementationTestCase {

    @Mock
    private CustomerRepo repo;

    @InjectMocks
    private CustomerServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCustomer() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890",
                "123 Street", "123456", new Date(), "30", "Male", "gokul@123");
        service.addCustomer(customer);
        verify(repo).save(customer);
    }

    @Test
    public void testGetAllCustomers() {
        CustomerSignup customer1 = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890",
                "123 Street", "123456", new Date(), "30", "Male", "gokul@123");
        CustomerSignup customer2 = new CustomerSignup(2, "Anand", "anand@gmail.com", "0987654321",
                "456 Avenue", "654321", new Date(), "25", "Male", "anand@123");
        when(repo.findAllCustomerSignups()).thenReturn(List.of(customer1, customer2));

        List<CustomerSignup> customers = service.getallCustomers();
        assertEquals(2, customers.size());
        assertEquals(customer1, customers.get(0));
        assertEquals(customer2, customers.get(1));
    }

    @Test
    public void testUpdateCustomer() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890",
                "123 Street", "123456", new Date(), "30", "Male", "gokul@123");
        service.updateCustomer(customer);
        verify(repo).update(customer);
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;
        service.deleteCustomer(customerId);
        verify(repo).deleteById(customerId);
    }

    @Test
    public void testFindCustomerById() {
        CustomerSignup customer = new CustomerSignup(1, "Gokul", "gokul@gmail.com", "1234567890",
                "123 Street", "123456", new Date(), "30", "Male", "gokul@123");
        when(repo.findById(anyInt())).thenReturn(customer);

        CustomerSignup foundCustomer = service.findCustomerById(1);
        assertNotNull(foundCustomer);
        assertEquals(1, foundCustomer.getCustomerId());
    }
}
