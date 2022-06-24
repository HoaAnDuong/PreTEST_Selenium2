package PageObjects;


import Constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YouTubePage {

    /**
     * YouTube Page
     */

    private final By _lblVideoTitle = By.xpath("//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]");

    private final By _btnTogglePlay = By.xpath("//button[@class=\"ytp-play-button ytp-button\"]");

    private String lblVideoTiming = "//div[@class='ytp-left-controls']/div//span[@class = 'ytp-time-current' and text()='&s']";

    /**
     * YouTube Page Web Element
     */

    private WebElement getLblVideoTitle(){
        return Constants.WEBDRIVER.findElement(_lblVideoTitle);
    }

    private WebElement getBtnTogglePlay(){
        return Constants.WEBDRIVER.findElement(_btnTogglePlay);
    }

    private List<WebElement> getLblVideoTiming(String pauseTime){
        return Constants.WEBDRIVER.findElements(By.xpath(String.format(pauseTime,lblVideoTiming)));
    }

    /**
     * YouTube Page Web Methods
     */

    public String getVideoTitle(){
        return getLblVideoTitle().getText();
    }

    public void clickTogglePlay(){
        this.getBtnTogglePlay().click();
    }

    public boolean isVideoPlay() {
        return getBtnTogglePlay().getAttribute("title").contains("Pause");
    }

    public void playVideo(){
        if(!isVideoPlay()){
            clickTogglePlay();
        }
    }

    public boolean isTimingLabel(String pauseTime){
        if(getLblVideoTiming(pauseTime).size() == 1){
            return true;
        }
        return false;
    }

    public void pauseVideoAfter(String pauseTime){
        Constants.WEBDRIVER.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);

        if (isTimingLabel(pauseTime)){
            clickTogglePlay();
        }
    }

}
