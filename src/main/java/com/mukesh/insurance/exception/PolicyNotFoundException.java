package com.mukesh.insurance.exception;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(Long id) {
        super("Policy not found with ID: " + id);
    }
}
