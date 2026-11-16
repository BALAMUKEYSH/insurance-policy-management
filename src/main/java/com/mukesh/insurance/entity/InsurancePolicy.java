package com.mukesh.insurance.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyholderName;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PolicyType policyType;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal coverageAmount;

    @Column(nullable = false)
    private Integer termYears;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PolicyStatus status;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected InsurancePolicy() { }

    public InsurancePolicy(String policyholderName, String email, PolicyType policyType,
                           BigDecimal coverageAmount, Integer termYears) {
        this.policyholderName = policyholderName;
        this.email = email;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.termYears = termYears;
        this.status = PolicyStatus.ACTIVE;
        this.startDate = LocalDate.now();
        this.createdAt = LocalDateTime.now();
    }

    public void updateDetails(String policyholderName, String email, PolicyType policyType,
                              BigDecimal coverageAmount, Integer termYears) {
        this.policyholderName = policyholderName;
        this.email = email;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.termYears = termYears;
    }

    public void cancel() {
        this.status = PolicyStatus.CANCELLED;
    }

    public Long getId() { return id; }
    public String getPolicyholderName() { return policyholderName; }
    public String getEmail() { return email; }
    public PolicyType getPolicyType() { return policyType; }
    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public Integer getTermYears() { return termYears; }
    public PolicyStatus getStatus() { return status; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
