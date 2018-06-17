package com.apress.prospring4.ch10;


import com.apress.prospring4.ch10.components.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropEditorExample {
    private static final Logger LOGGER = Logger.getLogger(PropEditorExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("prop-editor-app-context.xml");

        LOGGER.info(context.getBean("natalia", Contact.class));

        LOGGER.info(context.getBean("timur",Contact.class));
    }
}
