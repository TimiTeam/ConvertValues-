package com.apress.prospring4.ch10.service.jsrSample;

import com.apress.prospring4.ch10.components.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service("myBeanValidatorService")
public class MyBeanValidatorService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer){
        return validator.validate(customer);

    }
}
