package com.research.service;

import com.research.exception.BusinessRuleViolationException;

public class ValidationService {

    public void validatePositive(double value, String field) {
        if (value <= 0) {
            throw new BusinessRuleViolationException(field + " must be positive");
        }
    }

    public void validateNotNull(Object obj, String field) {
        if (obj == null) {
            throw new BusinessRuleViolationException(field + " cannot be null");
        }
    }
}
