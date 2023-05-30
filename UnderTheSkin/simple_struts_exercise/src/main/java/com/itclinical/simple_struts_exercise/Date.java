package com.itclinical.simple_struts_exercise;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import freemarker.core.ParseException;

public class Date {

    private String date;
    StringHelper myChecker = new StringHelper();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date(String myDate) {
        if(!isDatePropertyInvalid(myDate)){  
            this.date = myDate;
        }
        else{
            this.date = null;
        }
    }

    public boolean isValidDateFormat(String date) {
        SimpleDateFormat myDateFormat = new SimpleDateFormat(StringHelper.DATE_FORMAT);
        myDateFormat.setLenient(false);        
        try {
            myDateFormat.parse(date);
            return true;
        }
        catch (java.text.ParseException e) {
            return false;
        }
    }

    public LocalDate GetLocalDate() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StringHelper.DATE_FORMAT);
        LocalDate userDate = LocalDate.parse(date, formatter);
        return userDate;
    }

    protected boolean isDatePropertyInvalid(String date) {
        return date == null || date.isEmpty() || (!isValidDateFormat(date));
    }
    
}
