package com.apress.prospring4.ch10.service;


import com.apress.prospring4.ch10.components.AnotherContact;
import com.apress.prospring4.ch10.components.Contact;
import org.springframework.core.convert.converter.Converter;

public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact>{

    public AnotherContact convert(Contact contact) {
        AnotherContact anotherContact = new AnotherContact();
        anotherContact.setFirstName(contact.getFirstName());
        anotherContact.setLastName(contact.getLastName());
        anotherContact.setBirthDate(contact.getBirthDate());
        anotherContact.setPersonalSite(contact.getPersonalSite());
        return anotherContact;
    }
}
