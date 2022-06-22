package Ultilities;

import Constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver {
    public static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
        Constants.WEBDRIVER = new org.openqa.selenium.chrome.ChromeDriver(options);
    }

    public static void quitBrowser() {
        Constants.WEBDRIVER.close();
    }
}
