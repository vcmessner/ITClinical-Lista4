package com.itclinical.simple_struts_exercise;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;

import freemarker.core.ParseException;

public class Age {
    private String age;

    public Age(String birthDate) {
        this.age = calculateAge(birthDate);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String calculateAge(String date){
        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
        Date myBirthDate = new Date(date);
        if(myBirthDate.getDate()!=null) {
            LocalDate birthDate;
            try {
                birthDate =myBirthDate.GetLocalDate();
                Period myAge = Period.between(birthDate, currentDate);
                return (myAge.getYears() + " years");
            } 
            catch (ParseException e) {
                e.printStackTrace();
                return "";
            }            
        }
        return "";
    }

    public boolean checkLegalAge(int legalAge, LocalDate date){
        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
        currentDate = currentDate.minusYears(legalAge);
        if(currentDate.isBefore(date)){
            return false;
        }             
        return true;
    }

    
    
}
