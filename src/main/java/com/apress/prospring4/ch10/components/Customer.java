package com.apress.prospring4.ch10.components;


import com.apress.prospring4.ch10.service.jsrSample.CheckIndividualValidator;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@CheckIndividualValidator
//To enable validation
public class Customer {

    @NotNull
    @Size(max = 60, min = 2)
    private String firstName;

    private String lastName;

    @NotNull
    private CustomerType customerType;

    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @AssertTrue(message = "Error! The individual customer should have a Gender and Last name defined! ")
    public boolean isIndividualCustomer(){
        boolean result = true;
        if(getCustomerType() != null && (this.customerType.equals(CustomerType.INDIVIDUAL)
                && (gender == null || lastName == null))){
            result = false;
        }
        return result;
    }


}
