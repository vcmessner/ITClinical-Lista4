package com.itclinical.simple_struts_exercise;

public class Country {

    private String countryName;
    private int legalAge;

    public String getCountry() {
        return countryName;
    }

    public void setCountry(String country) {
        this.countryName = country;
    }

    public Country(String myCountry) {
        this.countryName = myCountry;
    }
    
}
