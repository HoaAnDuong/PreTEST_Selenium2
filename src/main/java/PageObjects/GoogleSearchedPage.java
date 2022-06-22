package PageObjects;

import Constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchedPage {

    /**
     * Searching Result Page
     */
    private final By _txtSearchInput = By.xpath("//input[@name='q' and @type='text']");
    private final By _lblMainResult = By.xpath("//div/h2[@data-attrid='title']/span");
    private final By _lstVideosSection = By.xpath("//div[@id='search']//h3[contains(text(),'Video')]/ancestor::div[@aria-level='2']/following-sibling::div/div/div");
    private final By _lstTopStoriesSection = By.xpath("//div[starts-with(@id,'NEWS_ARTICLE_RESULT')]");

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

    public void inputSearchBox(String searchKeyWord){
        this.getTxtSearchInput().sendKeys(searchKeyWord);
        this.getTxtSearchInput().sendKeys(Keys.RETURN);
    }

}
