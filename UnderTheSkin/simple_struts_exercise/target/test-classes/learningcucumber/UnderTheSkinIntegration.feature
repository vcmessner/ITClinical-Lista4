Feature: Is user allowed?
Check if the user input are valid, the resulting allowed status and the user age. User age Should be "" if no valid data input is found.

    Scenario Outline: Country is UK and user inputs are valid
        Given user submits name "<inputName>", date "<inputDate>" and is from UK
        When i ask whether user the input is valid
        Then input is valid = "<isValid>"

        Examples:
        | inputName      | inputDate      |  isValid |
        | Algo           | 24/05/1900     |  success | #old
        | Algo           | 24/05/2005     |  success | #0 years prior
        | Algo           | 31/12/2005     |  input   | #0 year later
        | Algo           | 24/05/2006     |  input   | #1 year later
        | Sunday         | 24/05/2010     |  input   | 
        | Algo           | 24/13/2010     |  input   | #Malformed month
        | Algo           | 29/02/2010     |  input   | #Malformed day
        |                | 24/05/2010     |  input   | #Malformed name
        | Algo           | 24/05/2010     |  input   | #Malformed country

    Scenario Outline: Country is US and user inputs are valid
        Given user submits name "<inputName>", date "<inputDate>" and is from US
        When i ask whether user the input is valid
        Then input is valid = "<isValid>"

        Examples:
        | inputName      | inputDate      |  isValid |
        | Algo           | 24/05/1900     |  success | #old
        | Algo           | 24/05/2002     |  success | #0 years prior
        | Algo           | 31/12/2002     |  input   | #0 year later
        | Algo           | 24/05/2003     |  input   | #1 year later
        | Sunday         | 24/05/2010     |  input   | 
        | Algo           | 24/13/2010     |  input   | #Malformed month
        | Algo           | 29/02/2010     |  input   | #Malformed day
        |                | 24/05/2010     |  input   | #Malformed name
        | Algo           | 24/05/2010     |  input   | #Malformed country

    
   
   
    Scenario Outline: Country is Spain and user inputs are valid
        Given user submits name "<inputName>", date "<inputDate>" and is from Spain
        When i ask whether user the input is valid
        Then input is valid = "<isValid>"

        Examples:
        | inputName      | inputDate      |  isValid |
        | Algo           | 24/05/1900     |  success | #old
        | Algo           | 24/05/2007     |  success | #0 years prior
        | Algo           | 31/12/2007     |  input   | #0 year later
        | Algo           | 24/05/2008     |  input   | #1 year later
        | Sunday         | 24/05/3000     |  input   | #not born
        | Algo           | 24/13/2010     |  input   | #Malformed month
        | Algo           | 29/02/2010     |  input   | #Malformed day
        |                | 24/05/2010     |  input   | #Malformed name
        | Algo           | 24/05/2010     |  input   | #Malformed country

    Scenario Outline: Country is Portugal and user inputs are valid
        Given user submits name "<inputName>", date "<inputDate>" and is from Portugal
        When i ask whether user the input is valid
        Then input is valid = "<isValid>"

        Examples:
        | inputName      | inputDate      |  isValid |
        | Algo           | 24/05/1900     |  success | #old
        | Algo           | 24/05/2007     |  success | #0 years prior
        | Algo           | 31/12/2007     |  input   | #0 year later
        | Algo           | 24/05/2008     |  input   | #1 year later
        | Sunday         | 24/05/3000     |  input   | #not born
        | Algo           | 24/13/2010     |  input   | #Malformed month
        | Algo           | 29/02/2010     |  input   | #Malformed day
        |                | 24/05/2010     |  input   | #Malformed name
        | Algo           | 24/05/2010     |  input   | #Malformed country

