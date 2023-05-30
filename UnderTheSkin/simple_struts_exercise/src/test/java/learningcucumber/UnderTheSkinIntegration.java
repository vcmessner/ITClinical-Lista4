/* package learningcucumber;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import com.itclinical.simple_struts_exercise.StringHelper;
import com.opensymphony.xwork2.ActionSupport;
import Helpers.UnderTheSkinHelpers;
import freemarker.core.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnderTheSkinIntegration {
    private String userIsAllowed;
    private StringHelper stringHelper = new StringHelper();
    private UnderTheSkinHelpers helper = new UnderTheSkinHelpers();
    private String myName;
    private String myDate;
    private int legalAge;
    Map<String, String> fieldParameterMap = new HashMap<>();

    //@Given("user submits name {string}, date {string} and is from {string}")
    //public void userSubmitsInput(String name, String date, String country) throws ParseException {
    @Given("user submits name {string}, date {string} and is from UK")
        public void userSubmitsUKInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = 18;
        helper.initServletRequestMockObject();
        try{
            helper.setUp();
            }
        catch(Exception e){
            e.printStackTrace();
        }
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);        
    }

    @Given("user submits name {string}, date {string} and is from US")
        public void userSubmitsUSInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = 21;
        helper.initServletRequestMockObject();
        try{
            helper.setUp();
            }
        catch(Exception e){
            e.printStackTrace();
        }
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);        
    }

    @Given("user submits name {string}, date {string} and is from Portugal")
        public void userSubmitsPORInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = 16;
        helper.initServletRequestMockObject();
        try{
            helper.setUp();
            }
        catch(Exception e){
            e.printStackTrace();
        }
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);        
    }

    @Given("user submits name {string}, date {string} and is from Spain")
        public void userSubmitsSPInput(String name, String date) throws ParseException {
        myName = stringHelper.trucateName(name);
        myDate = date;
        legalAge = 16;
        helper.initServletRequestMockObject();
        try{
            helper.setUp();
            }
        catch(Exception e){
            e.printStackTrace();
        }
        fieldParameterMap.put("name", myName);
        fieldParameterMap.put("date", myDate);  
        //fieldParameterMap.put("country", myName);     
    }

    @When("i ask whether user the input is valid")
    public void iAskWhetherUserIsAllowed() {
        String URI ="/simple_struts_exercise/helloWorldAction.action";
        ActionSupport myAction;
        try{
            //helper.getRequest().addParameter("name", myName);
            helper.getRequest().addParameters(fieldParameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            myAction = helper.createAction(URI, true);
            userIsAllowed = helper.executeProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("input is valid = {string}")
    public void userAllowedValueIs(String answer) {
        assertEquals(answer, userIsAllowed);
    }
}
*/