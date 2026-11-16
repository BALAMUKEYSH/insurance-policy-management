package com.mukesh.insurance.repository;

import com.mukesh.insurance.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<InsurancePolicy, Long> { }
