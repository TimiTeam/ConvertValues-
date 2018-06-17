package com.apress.prospring4.ch10.service;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditorSupport;

public class DateTimeEditorRegistrar implements PropertyEditorRegistrar{
    private DateTimeFormatter formatter;

    public DateTimeEditorRegistrar(String dataFormatPattern) {
        this.formatter = DateTimeFormat.forPattern(dataFormatPattern);
    }

    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {

        propertyEditorRegistry.registerCustomEditor(DateTime.class,new DateTimeEditor(formatter));
    }

    private static class DateTimeEditor extends PropertyEditorSupport{
        private DateTimeFormatter timeFormatter;

        public DateTimeEditor(DateTimeFormatter formatter) {
            this.timeFormatter = formatter;
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(DateTime.parse(text,timeFormatter));
        }
    }
}
