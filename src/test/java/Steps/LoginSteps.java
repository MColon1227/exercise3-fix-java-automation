package Steps;

import Base.BaseUtil;
import PageObject.PageObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class LoginSteps extends BaseUtil {

    PageObject fillOut;
    PageObject searchProduct;

    public LoginSteps() {
        getDriver();
        beforeSuite();
    }

    @Given("^I have to navigate to the Amazon Page$")
    public void iHaveToNavigateToTheAmazonPage()
    {
        System.out.println("I have to navigate to the Amazon Page");
        driver.get(BaseUtil.BASE_URL);
        PageObject identifySection = new PageObject(driver);
        identifySection.identifyAccount();
    }

    @And("^I enter username([^\"]*)")
    public void iEnterUsername(String username, DataTable table)
    {
        waitHandle();

        fillOut = new PageObject(driver);
        System.out.println("I enter the username");
        List<String> data = table.asList(String.class);
        System.out.println("The value is: " + data.get(1));
        fillOut.enterEmail(data.get(1));
    }

    @And("^I click the continue button$")
    public void iClickTheContinueButton()
    {
        System.out.println("I click the continue button");
        fillOut.pressContinueButtonEmail();
    }

    @And("^I enter the password([^\"]*)$")
    public void iEnterThePassword(String password, DataTable table)
    {
        System.out.println("I enter the password");
        List<String> data = table.asList(String.class);
        System.out.println("The value is: " + data.get(1));
        fillOut.enterPassword(data.get(1));
    }

    @Then("^I click the login button$")
    public void iClickTheLoginButton()
    {
        System.out.println("I click the Login button");
        fillOut.pressSubmitButton();
    }


    @And("^I search for product: Samsung Galaxy S9 64GB$")
    public void iSearchForProductSamsungGalaxySGB() {
        System.out.println("I search for product: Samsung Galaxy S9 64GB");
        searchProduct = new PageObject(driver);
        searchProduct.searchInput("Samsung Galaxy S9 64GB");
        searchProduct.pressSearchInputButton();
    }

    @And("^I Select first product and save the price And Click on the product$")
    public void iSelectFirstProductAndSaveThePriceAndClickOnTheProduct() {
        waitHandle();

        System.out.println("I Select first product and save the price and Click on the product and Validate first price vs detail price");
        String savedPrice = searchProduct.savedPrice();
        searchProduct.savedPriceClick();
        waitHandle();

        System.out.println("I Validate first price vs detail price");
        String detailPrice = searchProduct.detailPrice();
        searchProduct.actualPriceResult();
        Assert.assertEquals(savedPrice, detailPrice);
        waitHandle();

        System.out.println("I Click on Add to Cart");
        searchProduct.addToCart();
        waitHandle();

        System.out.println("I Validate again, first price vs current price");
        String savedActualPrice = searchProduct.actualPrice();
        Assert.assertEquals(detailPrice, savedActualPrice);
    }

    @And("^I Validate that the Shop car has (\\d+) as a number$")
    public void iValidateThatTheShopCarHasAsANumber(int arg0) {
        System.out.println("I Validate that the Shop car has 1 as a number");
        String savedShopCart = searchProduct.shopCart();
        Assert.assertEquals(savedShopCart , "1");
    }

    @And("^I Search for another product: Alienware Aw3418DW$")
    public void iSearchForAnotherProductAlienwareAwDW() {
        System.out.println("I Search for another product: Alienware Aw3418DW");
        searchProduct.searchInput("Alienware Aw3418DW");
        searchProduct.pressSearchInputButton();
    }

    @And("^I Select First product And Add to Cart$")
    public void iSelectFirstProductAndAddToCart() {
        System.out.println("I Select First product and add to the cart");
        searchProduct.clickFirstProduct();
        searchProduct.addToCart();
    }

    @Then("^I Verify that the cart number is now (\\d+)$")
    public void iVerifyThatTheCartNumberIsNow(int arg0) {
        System.out.println("I Verify that the cart number is now 2");
        String savedShopCart2 = searchProduct.shopCart();
        Assert.assertEquals(savedShopCart2 , "2");
        waitHandle();

        afterSuite();
    }
}
