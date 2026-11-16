package com.mukesh.insurance.service;

import com.mukesh.insurance.dto.PolicyRequest;
import com.mukesh.insurance.entity.InsurancePolicy;
import com.mukesh.insurance.exception.PolicyNotFoundException;
import com.mukesh.insurance.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PolicyService {
    private final PolicyRepository repository;

    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    public InsurancePolicy create(PolicyRequest request) {
        InsurancePolicy policy = new InsurancePolicy(
                request.policyholderName(), request.email(), request.policyType(),
                request.coverageAmount(), request.termYears());
        return repository.save(policy);
    }

    @Transactional(readOnly = true)
    public List<InsurancePolicy> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public InsurancePolicy findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PolicyNotFoundException(id));
    }

    public InsurancePolicy update(Long id, PolicyRequest request) {
        InsurancePolicy policy = findById(id);
        policy.updateDetails(request.policyholderName(), request.email(), request.policyType(),
                request.coverageAmount(), request.termYears());
        return repository.save(policy);
    }

    public InsurancePolicy cancel(Long id) {
        InsurancePolicy policy = findById(id);
        policy.cancel();
        return repository.save(policy);
    }
}
