package learningcucumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.format.datetime.joda.LocalDateParser;

import com.itclinical.simple_struts_exercise.HelloWorldAction;
import com.itclinical.simple_struts_exercise.StringHelper;

import freemarker.core.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class IsUserAllowed {

    private HelloWorldAction myAction;
    private String userIsAllowed;
    private StringHelper stringHelper = new StringHelper();

    //@Given("the name {string}, the country {string}, days interval {int}")
    @Given("the name {string}, the country {string}, has elapsed {int} years {int} months {int} days")
    public void userSubmits(String name, String country, int years, int months, int days) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StringHelper.DATE_FORMAT);        
        LocalDate currentDate = LocalDate.now(ZoneOffset.UTC);
        currentDate=currentDate.minusYears(years);
        currentDate=currentDate.minusMonths(months);      
        currentDate=currentDate.minusDays(days);
        name = stringHelper.trucateName(name);
        myAction = new HelloWorldAction(name,currentDate.format(formatter),country);        
    }

    @When("we want to abstract the user date input and check if the day intervals provide valid reply")
    public void iAskWhetherUserIsAllowed() throws Exception {
        if (myAction.saveUsername() && myAction.saveDate()){
            userIsAllowed = "True";
        }
        else{
            userIsAllowed = "False";
        }
    }
    @Then("user allowed value is {string}")
    public void userAllowedValueIs(String Answer) {
        assertEquals(Answer, userIsAllowed);
    }

}
