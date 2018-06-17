package com.apress.prospring4.ch10;


import com.apress.prospring4.ch10.components.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvFormatServExample {
    private static final Logger LOGGER = Logger.getLogger(ConvFormatServExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conv-format-service-app-context.xml");

        Contact contact = context.getBean("contact",Contact.class);

        LOGGER.info("Attention please: "+contact);

        ConversionService service = context.getBean("conversionService",ConversionService.class);

        String birthDate = service.convert(contact.getBirthDate(),String.class);
        LOGGER.info("Sting type: "+birthDate);

    }
}
