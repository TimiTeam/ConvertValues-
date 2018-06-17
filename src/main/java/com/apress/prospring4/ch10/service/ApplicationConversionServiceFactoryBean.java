package com.apress.prospring4.ch10.service;


import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean{
    private static final Logger LOG = Logger.getLogger(ApplicationConversionServiceFactoryBean.class);


    private static final String DATE_DEFAULT_PATTERN = "yyyy-MM-dd";

    private DateTimeFormatter dateTimeFormatter;
    private String datePattern = DATE_DEFAULT_PATTERN;
    private Set<Formatter<?>> formatterSet = new HashSet<Formatter<?>>();

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init(){
        dateTimeFormatter = DateTimeFormat.forPattern(datePattern);
        formatterSet.add(getDateTimeFormatter());
        setFormatters(formatterSet);
    }

    public Formatter<DateTime> getDateTimeFormatter(){
        return new Formatter<DateTime>() {

//            The parse () method parses the String format and builds the DateTime type
            public DateTime parse(String s, Locale locale) throws ParseException {
                LOG.info("Parsing the date string: "+s);
                return dateTimeFormatter.parseDateTime(s);
            }

//            The print () method formats an instance of DateTime into a String.
            public String print(DateTime dateTime, Locale locale) {
                LOG.info("Formatting the date time: "+dateTime);
                return dateTimeFormatter.print(dateTime);
            }
        };
    }
}

