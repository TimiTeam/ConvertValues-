package com.apress.prospring4.ch10.service.jsrSample;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.TYPE)
// Means that the annotation should only be applied at the class level
@Constraint(validatedBy = IndividualCustomerValidator.class)
// It is a validator, and the attribute validatedBy specifies a class that provides validation logic
@Documented
public @interface CheckIndividualValidator {
    String message() default "Individual customer should have a Last name and Gender defined!";
    Class<?>[] groups()default{};
    Class<? extends Payload>[] payload() default {};
}
