package com.mukesh.insurance.dto;

import com.mukesh.insurance.entity.PolicyType;
import java.math.BigDecimal;

public record PremiumEstimate(
        PolicyType policyType,
        BigDecimal coverageAmount,
        Integer termYears,
        BigDecimal annualRate,
        BigDecimal estimatedPremium
) { }
