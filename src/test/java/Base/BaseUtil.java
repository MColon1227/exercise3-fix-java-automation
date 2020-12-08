package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;


public class BaseUtil {

    public final static String BASE_URL = "https://www.amazon.com.mx/";
    public final static String CHROME_DRIVER_LOCATION = "chromedriver";

    //-------------------->

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void waitHandle() {
        try{
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("test-pass");
        } catch(Exception e){
            System.out.println("test-fail");
            System.out.println(e.toString());
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Close browser!");
        driver.close();
    }
}
