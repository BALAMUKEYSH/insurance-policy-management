package com.mukesh.insurance.service;

import com.mukesh.insurance.entity.PolicyType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {
    private final PremiumCalculator calculator = new PremiumCalculator();

    @Test
    void calculatesHealthPremium() {
        BigDecimal result = calculator.calculate(
                PolicyType.HEALTH, new BigDecimal("500000"), 1);

        assertEquals(new BigDecimal("6000.00"), result);
    }

    @Test
    void calculatesMultiYearLifePremium() {
        BigDecimal result = calculator.calculate(
                PolicyType.LIFE, new BigDecimal("1000000"), 2);

        assertEquals(new BigDecimal("16000.00"), result);
    }

    @Test
    void rejectsInvalidTerm() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(PolicyType.HEALTH, new BigDecimal("500000"), 0));
    }
}
