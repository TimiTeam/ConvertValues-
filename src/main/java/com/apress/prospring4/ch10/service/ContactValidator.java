package com.apress.prospring4.ch10.service;


import com.apress.prospring4.ch10.components.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("contactValidator")
public class ContactValidator implements Validator{

//    Indicates whether the validator supports validation for the class passed to it.
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }


//    Performs a validation for the object transferred to it.
// The result will be stored in the instance of the implementation of the interface org.springfrarnework.validation.Errors.
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty! Hello, im errors");
    }
}
