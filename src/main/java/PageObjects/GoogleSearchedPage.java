package PageObjects;

import Constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchedPage {

    /**
     * Searching Result Page
     */
    private final By _txtSearchInput = By.xpath("//input[@name='q' and @type='text']");
    private final By _lblMainResult = By.xpath("//div/h2[@data-attrid='title']/span");
    private final By _lstVideosSection = By.xpath("//div[@id='search']//h3[contains(text(),'Video')]/ancestor::div[@aria-level='2']/following-sibling::div/div/div");
    private final By _lstTopStoriesSection = By.xpath("//div[@id='search']//h3[contains(text(),'Top stories')]//ancestor::div[@aria-level='2']/parent::div/following-sibling::div//div/a//div[@role='heading']");

    /**
     * Searching Result Page WebElement
     */
    private WebElement getTxtSearchInput(){
        return Constants.WEBDRIVER.findElement(_txtSearchInput);
    }

    private WebElement getLblMainResult(){
        return Constants.WEBDRIVER.findElement(_lblMainResult);
    }

    public List<WebElement> getLstVideosSection(){
        return Constants.WEBDRIVER.findElements(_lstVideosSection);
    }

    private List<WebElement> getLblVideosTitle(String searchKey){
        return Constants.WEBDRIVER.findElements(By.xpath(_lstVideosSection.toString().replaceAll("By.xpath: ", "") + "//div[contains(text(),'" + searchKey +"')]"));
    }

    private List<WebElement> getLstTopStoriesSection(){
        return Constants.WEBDRIVER.findElements(_lstTopStoriesSection);
    }

    /**
     *  Searching Result Page Functions
     */
    public void navigateToGoogle(){
        Constants.WEBDRIVER.get(Constants.GOOGLE_URL);
    }

    public void searchKeyWord(String searchKey){
        this.getTxtSearchInput().sendKeys(searchKey);
        this.getTxtSearchInput().sendKeys(Keys.RETURN);
    }

    public String getSearchInputKeyWord(){
        return getTxtSearchInput().getAttribute("value");
    }

    public String getMainResultText(){
        System.out.println("Main Result: " + getLblMainResult().getText());
        return getLblMainResult().getText();
    }

    public List<String> getListVideosTitle(String searchKey){
        List<String> videosTitle = new ArrayList<>();
        for (WebElement lblVideoTitle : getLblVideosTitle(searchKey)) {
            String videoTitle = lblVideoTitle.getText();
            videosTitle.add(videoTitle);
        }
        return videosTitle;
    }

    public List<String> getListTopStories(){
        List<String> topStoriesTitle = new ArrayList<>();
        for (WebElement lblStoriesTitle : getLstTopStoriesSection()){
            String storiesTitle = lblStoriesTitle.getText();
            topStoriesTitle.add(storiesTitle);
        }
        return topStoriesTitle;
    }

    public boolean isStoryText(){
        return getListTopStories().stream().allMatch(str -> str.trim().contains(Constants.KEYWORD));
    }

    public boolean isVideoText(){
        return getListVideosTitle(Constants.KEYWORD).stream().allMatch(str -> str.trim().contains(Constants.KEYWORD));
    }

    /**
     *  Getting Data from Element Methods (not for TCs)
     */

    public void readVideoTitleArray(){
        String [] videosTitleArray = getListVideosTitle(Constants.KEYWORD).toArray(new String[getListVideosTitle(Constants.KEYWORD).size()]);
        for (String videoTitle : videosTitleArray){
            System.out.println(videoTitle);
        }

        String [] storyTitleArray = getListTopStories().toArray(getListTopStories().toArray(new String[getListTopStories().size()]));
        for (String storyTitle: storyTitleArray){
            System.out.println(storyTitle);
        }
    }

}
