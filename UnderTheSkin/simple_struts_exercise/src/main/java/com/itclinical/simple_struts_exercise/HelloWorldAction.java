package com.itclinical.simple_struts_exercise;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
    
    //public static final int LEGAL_AGE = 18;
    public static final String INVALID_AGE_MESSAGE_STRING = "Please enter a valid Age!";
    public static final String INVALID_NAME_MESSAGE_STRING = "Please enter a valid Name!";
    public static final String AGE_RESTICTION_MESSAGE_STRING = "Minors are not allowed!";
    public static final String INVALID_DATE_MESSAGE_STRING = "Invalid Date. Date should be in format DD/MM/YYYY!";
    StringHelper myChecker = new StringHelper();

    private Name myName;
    private Date myDate;
    private Age myAge;
    String name;
    String date;
    String age;

    int legalAge=18;

    public HelloWorldAction(String name, String date) {
        this.myName = new Name(name);
        this.myDate = new Date(date);
        this.myAge = new Age(date);
    }
  //@autowire
    public HelloWorldAction(String name, String date, String legalAge) {
        this.myName = new Name(name);
        this.myDate = new Date(date);
        this.legalAge = Integer.parseInt(legalAge);
        this.myAge = new Age(date);
        this.name=name;
        this.date=date;
        this.age = myAge.getAge();
    }

    public HelloWorldAction() {
        
    }
    public String execute() throws Exception{
        this.myName = new Name(name);
        this.myDate = new Date(date);
        if(myDate.getDate()!=null){
            this.myAge = new Age(date);
        }
        else{
            this.myAge = null;
        }

        if(saveDate() && saveUsername()){
            return ActionSupport.SUCCESS;
        }
        return ActionSupport.INPUT;        
    }

    public boolean saveDate() throws Exception {
        if(myDate.getDate()==null) {
            addActionError(INVALID_DATE_MESSAGE_STRING);
            return false;
        }
        if(myAge.checkLegalAge(legalAge,myDate.GetLocalDate())){
            return true;
        }
        else{
            addActionError(AGE_RESTICTION_MESSAGE_STRING);
            return false;
        }
    }

    public boolean saveUsername() throws Exception {
        if(myName.getName()==null) {
            addActionError(INVALID_NAME_MESSAGE_STRING);
            return false;        
        }
        return true;        
        }

    /*public LocalDate stringToDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StringHelper.DATE_FORMAT);
        LocalDate userDate = LocalDate.parse(date, formatter);
        return userDate;
    }*/

    

    /*public String calculateAge(String date){
        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
        if(!isDatePropertyInvalid()) {
            LocalDate birthDate;
            try {
                birthDate = stringToDate(date);
                Period myAge = Period.between(birthDate, currentDate);
            return (myAge.getYears() + " years");
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }            
        }
        else{
            return "";
        }
    }
    /*
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
    }*/
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return myAge.getAge();
    }
    public void setAge(String age) {
        this.age = age;
    }


    
}