package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.InsuranceClaim;
import com.micro.claim.model.Settlement;
import com.micro.claim.repo.SettlementRepo;

public class SettlementServiceImplementationTestCase {

    @Mock
    private SettlementRepo repo;

    @InjectMocks
    private SettlementServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddSettlement() {
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        Settlement settlement = new Settlement(1, 5000, "Pending", insuranceClaim);
        service.addSettlement(settlement);
        verify(repo).save(settlement);
    }

    @Test
    public void testGetAllSettlements() {
        InsuranceClaim insuranceClaim1 = new InsuranceClaim(); 
        InsuranceClaim insuranceClaim2 = new InsuranceClaim();
        Settlement settlement1 = new Settlement(1, 5000, "Pending", insuranceClaim1);
        Settlement settlement2 = new Settlement(2, 7000, "Approved", insuranceClaim2);
        when(repo.findAllSettlements()).thenReturn(Arrays.asList(settlement1, settlement2));
        List<Settlement> settlements = service.getallSettlements();
        assertEquals(2, settlements.size());
        assertEquals(settlement1, settlements.get(0));
        assertEquals(settlement2, settlements.get(1));
    }

    @Test
    public void testUpdateSettlement() {
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        Settlement settlement = new Settlement(1, 5000, "Pending", insuranceClaim);
        service.updateSettlement(settlement);

        verify(repo).update(settlement);
    }

    @Test
    public void testDeleteSettlement() {
        int settlementId = 1;
        service.deleteSettlement(settlementId);
        verify(repo).deleteById(settlementId);
    }
}
