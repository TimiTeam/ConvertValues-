package com.apress.prospring4.ch10;


import com.apress.prospring4.ch10.components.Customer;
import com.apress.prospring4.ch10.components.CustomerType;
import com.apress.prospring4.ch10.service.jsrSample.MyBeanValidatorService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

public class JSR349Sample {
    private static final Logger LOGGER  = Logger.getLogger(JSR349Sample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jsr349-app-context.xml");

        MyBeanValidatorService service = context.getBean("myBeanValidatorService",MyBeanValidatorService.class);

        Customer customer = new Customer();
        customer.setFirstName("J");
        customer.setLastName("Nikson");

        validateCustomer(customer,service);

        customer.setCustomerType(CustomerType.CORPORATE);

        customer.setFirstName("Jack");

        validateCustomer(customer,service);

    }

    private static void validateCustomer(Customer customer, MyBeanValidatorService validatorService){

        Set<ConstraintViolation<Customer>> violationSet = new HashSet<ConstraintViolation<Customer>>();

        violationSet = validatorService.validateCustomer(customer);

        showAllViolations(violationSet);

    }

    private static void showAllViolations(Set<ConstraintViolation<Customer>> violationSet){
        LOGGER.info("No. of violations: "+violationSet.size());

        for(ConstraintViolation<Customer> c:violationSet){
            LOGGER.info("Validation error of property: "+c.getPropertyPath()+", "+
            "with value: "+c.getInvalidValue()+", "+
            "message: "+c.getMessage());
        }
    }
}
