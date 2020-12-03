package Steps;

import Base.BaseUtil;
import PageObject.PageObject;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    PageObject fillOut;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }
    WebDriver driver = new ChromeDriver();

    @Given("^I have to navigate to the Amazon Page$")
    public void iHaveToNavigateToTheAmazonPage() throws Throwable
    {
        System.out.println("I have to navigate to the Amazon Page");
        driver.get(BaseUtil.BASE_URL);
        PageObject identifySection = new PageObject(driver);
        identifySection.identifyAccount();
    }

    @And("^I enter username([^\"]*)$")
    public void iEnterUsername(String username, DataTable table)
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fillOut = new PageObject(driver);
        System.out.println("I enter the username");
        fillOut.enterEmail(username);
    }

    @And("^I click the continue button$")
    public void iClickTheContinueButton()
    {
//        PageObject fillOut = new PageObject(driver);
        System.out.println("I click the continue button");
        fillOut.pressContinueButtonEmail();
    }

    @And("^I enter the password([^\"]*)$")
    public void iEnterThePassword(String password, DataTable table)
    {
//        PageObject fillOut = new PageObject(driver);
        System.out.println("I enter the password");
        fillOut.enterPassword(password);
    }

    @Then("^I click the login button$")
    public void iClickTheLoginButton() throws Throwable
    {
//        PageObject fillOut = new PageObject(driver);
        System.out.println("I click the Login button");
        fillOut.pressSubmitButton();
    }
}
