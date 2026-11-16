package com.mukesh.insurance.service;

import com.mukesh.insurance.entity.InsurancePolicy;
import com.mukesh.insurance.exception.PolicyNotFoundException;
import com.mukesh.insurance.repository.PolicyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PolicyServiceTest {

    @Mock
    private PolicyRepository repository;

    @InjectMocks
    private PolicyService policyService;

    @Test
    void shouldReturnAllPolicies() {
        InsurancePolicy policy = mock(InsurancePolicy.class);
        when(repository.findAll()).thenReturn(List.of(policy));
        List<InsurancePolicy> result = policyService.findAll();
        assertEquals(1, result.size());
        assertSame(policy, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void shouldReturnPolicyWhenIdExists() {
        InsurancePolicy policy = mock(InsurancePolicy.class);
        when(repository.findById(1L)).thenReturn(Optional.of(policy));
        InsurancePolicy result = policyService.findById(1L);
        assertSame(policy, result);
        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenPolicyNotFound() {
        when(repository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(PolicyNotFoundException.class, () -> policyService.findById(100L));
        verify(repository).findById(100L);
    }
}
