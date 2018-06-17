package com.apress.prospring4.ch10;


import com.apress.prospring4.ch10.components.AnotherContact;
import com.apress.prospring4.ch10.components.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PropEditorExample {
    private static final Logger LOGGER = Logger.getLogger(PropEditorExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conv-service-app-context.xml");

        Contact contact = context.getBean("man",Contact.class);
        LOGGER.info(contact.getClass().getCanonicalName()+" __ "+contact);

        ConversionService service = context.getBean(ConversionService.class);

        AnotherContact another = service.convert(contact,AnotherContact.class);
        LOGGER.info(another.getClass().getCanonicalName()+" __ "+another);

        String[] stringsArray = service.convert("a,b,c,d",String[].class);
        LOGGER.info("Here we look at String array:");
        for (String s: stringsArray){
            LOGGER.info(s);
        }
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("Hello");
        listStrings.add("Good morning");
        listStrings.add("Im glad to see you");

        Set<String> setStrings = service.convert(listStrings, HashSet.class);
        LOGGER.info("Here we look at HashSet ");
        for(String s: setStrings){
            LOGGER.info(s);
        }

    }
}
