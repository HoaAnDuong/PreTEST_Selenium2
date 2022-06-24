package TestBase;

import Constant.Constants;
import Ultilities.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        ChromeDriver.openChromeBrowser();
        Constants.WEBDRIVER.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        ChromeDriver.quitBrowser();
    }
}
