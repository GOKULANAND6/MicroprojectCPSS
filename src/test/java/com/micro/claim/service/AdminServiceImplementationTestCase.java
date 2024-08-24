package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.micro.claim.model.AdminSignup;
import com.micro.claim.repo.AdminRepo;

public class AdminServiceImplementationTestCase {

    @Mock
    private AdminRepo repo;

    @InjectMocks
    private AdminServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAdmin() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "gokul@123");
        service.addAdmin(admin);
        verify(repo, times(1)).save(admin);
    }

    @Test
    public void testGetAllAdmins() {
        AdminSignup admin1 = new AdminSignup(1, "Gokul", "1234567890", "gokul@123");
        AdminSignup admin2 = new AdminSignup(2, "Gokul", "0987654321", "gokul@123");
        when(repo.findAllAdminSignups()).thenReturn(List.of(admin1, admin2));

        List<AdminSignup> admins = service.getallAdmins();
        assert(admins.size() == 2);
        assert(admins.contains(admin1));
        assert(admins.contains(admin2));
    }

    @Test
    public void testUpdateAdmin() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "gokul@123");
        service.updateAdmin(admin);
        verify(repo, times(1)).update(admin);
    }

    @Test
    public void testDeleteAdmin() {
        int adminId = 1;
        service.deleteAdmin(adminId);
        verify(repo, times(1)).deleteById(adminId);
    }

    @Test
    public void testFindAdminById() {
        AdminSignup admin = new AdminSignup(1, "Gokul", "1234567890", "gokul@123");
        when(repo.findById(anyInt())).thenReturn(admin);

        AdminSignup foundAdmin = service.findAdminById(1);
        assert(foundAdmin != null);
        assert(foundAdmin.getAdminId() == 1);
    }
}
