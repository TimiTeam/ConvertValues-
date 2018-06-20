package com.apress.prospring4.ch10.service.jsrSample;


import com.apress.prospring4.ch10.components.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualValidator,Customer>{
// This class implements the Const View Validator <CheckIndividualCustomer, Customer> interface,
// which means that the validator looks for the CheckIndividualCustomer annotation in the Customer classes.

    public void initialize(CheckIndividualValidator constraintAnnotation) {

    }

    public boolean isValid(Customer customer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;

        if(customer.getCustomerType() != null && (customer.isIndividualCustomer()
                && (customer.getLastName() == null || customer.getGender() == null))){
            result = false;
        }
        return result;
    }
}
