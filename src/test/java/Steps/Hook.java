package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    //private static final WebDriver driver = new ChromeDriver();

    @Before
    public void InitializeTest()
    {
        System.out.println("Opening the Browser");
        //Passing a dummy web driver instance

        base.StepInfo = "ChromeDriver";
        System.setProperty("webdriver.chrome.driver", BaseUtil.CHROME_DRIVER_LOCATION);
    }

    @After
    public void TearDownTest()
    {
        System.out.println("Closing the Browser");
       // driver.close();
    }
}
