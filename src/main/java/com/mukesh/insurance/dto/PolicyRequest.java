package com.mukesh.insurance.dto;

import com.mukesh.insurance.entity.PolicyType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record PolicyRequest(
        @NotBlank @Size(max = 100) String policyholderName,
        @NotBlank @Email @Size(max = 150) String email,
        @NotNull PolicyType policyType,
        @NotNull @DecimalMin(value = "1000.00") @Digits(integer = 12, fraction = 2)
        BigDecimal coverageAmount,
        @NotNull @Min(1) @Max(30) Integer termYears
) { }
