package com.apress.prospring4.ch10;


import com.apress.prospring4.ch10.components.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

public class SpringValidatorSample {
    private static final Logger LOGGER = Logger.getLogger(SpringValidatorSample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-validation-app-context.xml");

        Contact contact = new Contact();
        contact.setFirstName(null);
        contact.setLastName("Shepfored");
        Validator validator = context.getBean("contactValidator",Validator.class);

        BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact,"Cris");
        ValidationUtils.invokeValidator(validator,contact,result);

        List<ObjectError> errors= result.getAllErrors();
        LOGGER.info("No of validation errors: "+errors.size());
        for(ObjectError e: errors){
            LOGGER.info(e.getCode());
        }

    }
}
