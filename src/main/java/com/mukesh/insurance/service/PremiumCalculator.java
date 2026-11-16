package com.mukesh.insurance.service;

import com.mukesh.insurance.entity.PolicyType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Component
public class PremiumCalculator {
    private static final Map<PolicyType, BigDecimal> ANNUAL_RATES = Map.of(
            PolicyType.LIFE, new BigDecimal("0.008"),
            PolicyType.HEALTH, new BigDecimal("0.012"),
            PolicyType.VEHICLE, new BigDecimal("0.020"),
            PolicyType.HOME, new BigDecimal("0.005")
    );

    public BigDecimal calculate(PolicyType type, BigDecimal coverageAmount, int termYears) {
        if (type == null || coverageAmount == null || termYears < 1) {
            throw new IllegalArgumentException("Policy type, coverage and a positive term are required");
        }
        return coverageAmount
                .multiply(ANNUAL_RATES.get(type))
                .multiply(BigDecimal.valueOf(termYears))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal annualRate(PolicyType type) {
        return ANNUAL_RATES.get(type);
    }
}
