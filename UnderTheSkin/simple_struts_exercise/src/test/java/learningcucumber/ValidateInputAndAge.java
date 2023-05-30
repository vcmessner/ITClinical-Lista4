package learningcucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.itclinical.simple_struts_exercise.HelloWorldAction;
import com.itclinical.simple_struts_exercise.StringHelper;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ValidateInputAndAge {
    private String userIsAllowed;
    private StringHelper stringHelper = new StringHelper();
    //private UnderTheSkinHelpers helper = new UnderTheSkinHelpers();
    private String myName;
    private String myDate;
    private String myCountry;
    private String legalAge;
    Map<String, String> fieldParameterMap = new HashMap<>();
    private HelloWorldAction myAction;

    //@Given("user submits name {string}, date {string} and is from {string}")
    //public void userSubmitsInput(String name, String date, String country) throws ParseException {
    @Given("user submits name {string}, date {string} and is from UK")
        public void userSubmitsUKInput(String name, String date){
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = "18";
        myCountry="UK";
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);
        fieldParameterMap.put("country", myCountry);
        myAction = new HelloWorldAction(name,date,legalAge);        
    }

    @Given("user submits name {string}, date {string} and is from US")
    public void userSubmitsUSInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = "21";
        myCountry="US";
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);
        fieldParameterMap.put("country", myCountry);  
        myAction = new HelloWorldAction(name,date,legalAge);     
    }

    @Given("user submits name {string}, date {string} and is from Portugal")
        public void userSubmitsPORInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = "16";
        myCountry="Portugal";
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);
        fieldParameterMap.put("country", myCountry); 
        myAction = new HelloWorldAction(name,date,legalAge);     
    }

    @Given("user submits name {string}, date {string} and is from Spain")
        public void userSubmitsSPInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = "16";
        myCountry="Spain";
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);
        fieldParameterMap.put("country", myCountry);
        myAction = new HelloWorldAction(name,date,legalAge); 
    }

    @When("i ask whether user the input is valid")
    public void iAskWhetherUserIsAllowed() throws Exception {
        String URI ="/simple_struts_exercise/helloWorldAction.action";
        if (myAction.execute().equals(ActionSupport.SUCCESS)){
            userIsAllowed = "success";
        }
        else{
            userIsAllowed = "input";
        }
    }


    @Then("input is valid = {string}")
    public void userAllowedValueIs(String answer) {
        assertEquals(answer, userIsAllowed);
    }
}