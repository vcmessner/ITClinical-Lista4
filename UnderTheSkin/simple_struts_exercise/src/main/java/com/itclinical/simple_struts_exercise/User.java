package com.itclinical.simple_struts_exercise;
import com.itclinical.simple_struts_exercise.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.itclinical.simple_struts_exercise.Age;
import com.itclinical.simple_struts_exercise.Name;
import com.itclinical.simple_struts_exercise.Country;

public class User {

    private Name name;
    private Age age;
    private Date birthDate;
    private Country country;
    private String legalAge;

    @Autowired
    public User(String myName, String birthDate, String myCountry) {
        this.name = new Name(myName);
        //this.myAge = new Age(myAge);
        this.birthDate = new Date(birthDate);
        this.country = new Country(myCountry);
        this.age = new Age(birthDate);
    }

    @Autowired
    public User(String myName, String myDate) {
        this.name = new Name(myName);
        this.birthDate = new Date(myDate);
    }


    public String getName() {
        return name.getName();
    }

    public String getAge() {
        return age.getAge();
    }

    

    public String getDate() {
        return birthDate.getDate();
    }

    

    public String getCountry() {
        return country.getCountry();
    }    

    public String getLegalAge() {
        return legalAge;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.birthDate = date;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setLegalAge(String legalAge) {
        this.legalAge = legalAge;
    }


    
}
