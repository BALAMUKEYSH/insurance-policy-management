package com.mukesh.insurance.controller;

import com.mukesh.insurance.dto.PolicyRequest;
import com.mukesh.insurance.dto.PremiumEstimate;
import com.mukesh.insurance.entity.InsurancePolicy;
import com.mukesh.insurance.entity.PolicyType;
import com.mukesh.insurance.service.PolicyService;
import com.mukesh.insurance.service.PremiumCalculator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
@Validated
public class PolicyController {
    private final PolicyService policyService;
    private final PremiumCalculator premiumCalculator;

    public PolicyController(PolicyService policyService, PremiumCalculator premiumCalculator) {
        this.policyService = policyService;
        this.premiumCalculator = premiumCalculator;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InsurancePolicy create(@Valid @RequestBody PolicyRequest request) {
        return policyService.create(request);
    }

    @GetMapping
    public List<InsurancePolicy> findAll() {
        return policyService.findAll();
    }

    @GetMapping("/{id}")
    public InsurancePolicy findById(@PathVariable Long id) {
        return policyService.findById(id);
    }

    @PutMapping("/{id}")
    public InsurancePolicy update(@PathVariable Long id, @Valid @RequestBody PolicyRequest request) {
        return policyService.update(id, request);
    }

    @PatchMapping("/{id}/cancel")
    public InsurancePolicy cancel(@PathVariable Long id) {
        return policyService.cancel(id);
    }

    @GetMapping("/premium-estimate")
    public PremiumEstimate estimatePremium(
            @RequestParam PolicyType policyType,
            @RequestParam @NotNull @DecimalMin("1000.00") BigDecimal coverageAmount,
            @RequestParam @Min(1) @Max(30) int termYears) {
        BigDecimal estimate = premiumCalculator.calculate(policyType, coverageAmount, termYears);
        return new PremiumEstimate(policyType, coverageAmount, termYears,
                premiumCalculator.annualRate(policyType), estimate);
    }
}
