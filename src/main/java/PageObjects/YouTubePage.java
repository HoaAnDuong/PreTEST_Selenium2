package PageObjects;


import Constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class YouTubePage {

    /**
     * YouTube Page
     */

    private final By _lblVideoTitle = By.xpath("//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]");

    private final By _btnTogglePlay = By.xpath("//button[@class='ytp-play-button ytp-button']");

    private String lblVideoTiming = "//div[@class='ytp-left-controls']/div//span[@class = 'ytp-time-current' and text()='%s']";

    private final By _btnAdSkip = By.xpath("//span[@class='ytp-ad-skip-button-container']");

    static Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * YouTube Page Web Element
     */

    private WebElement getLblVideoTitle() {
        return Constants.WEBDRIVER.findElement(_lblVideoTitle);
    }

    private WebElement getBtnTogglePlay() {
        return Constants.WEBDRIVER.findElement(_btnTogglePlay);
    }

    private List<WebElement> getLblVideoTiming(String pauseTime) {
        return Constants.WEBDRIVER.findElements(By.xpath(String.format(lblVideoTiming, pauseTime)));
    }

    private List<WebElement> getBtnAdSkip() {
        return Constants.WEBDRIVER.findElements(_btnAdSkip);
    }

    /**
     * YouTube Page Web Methods
     */

    public String getVideoTitle() {
        System.out.println(getLblVideoTitle().getText());
        return getLblVideoTitle().getText();
    }

    public void clickTogglePlay() {
        this.getBtnTogglePlay().click();
    }

    public boolean isVideoPlay() {
        return getBtnTogglePlay().getAttribute("title").contains("Pause");
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void moveMouseToButton(WebElement element) {
        int offsetX = (element.getLocation().x + (element.getSize().width) / 2);
        int offsetY = (element.getLocation().y + (element.getSize().height) / 2 + 100);
        robot.mouseMove(offsetX, offsetY);
    }

    public void playVideo() {
        if (!isVideoPlay()) {
            clickTogglePlay();
        }

        if (this.getBtnAdSkip().size() == 1) {
            this.getBtnAdSkip().get(0).click();
        }

        wait(8000);
        moveMouseToButton(getBtnTogglePlay());
    }

    public boolean isTimingLabel(String pauseTime) {
        if (getLblVideoTiming(pauseTime).size() == 1) {
            System.out.println("at 0:10");
            return true;
        }
        return false;
    }

    public void pauseVideoAfter(String pauseTime) {
        this.playVideo();

        if (isTimingLabel(pauseTime)) {
            clickTogglePlay();
        }
    }

}
