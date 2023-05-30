package com.itclinical.simple_struts_exercise;

import java.util.HashMap;
import java.util.Map;

public class Country {

    private String countryName;
    private int legalAge;
    Map<String, Integer> myMap = new HashMap<String, Integer>();
    public String getCountry() {
        return countryName;
        
    }

    public void setCountry(String country) {
        this.countryName = country;
    }

    public Country(String myCountry) {
        this.countryName = myCountry;
        myMap.put("UK",18);
        myMap.put("US",21);
        myMap.put("Portugal",16);
        myMap.put("Spain",16);
    }

    public int getLegalAge() {
        return myMap.get(countryName);
    }
    
}
