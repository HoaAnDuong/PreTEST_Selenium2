package TestBase;

import Ultilities.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        ChromeDriver.openChromeBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
        ChromeDriver.quitBrowser();
    }
}
