package TestCases;

import Constant.Constants;
import PageObjects.GoogleSearchedPage;
import PageObjects.YouTubePage;
import TestBase.TestBase;
import org.testng.annotations.Test;

public class TC2 extends TestBase {

    @Test(description = "TC2 - Verify the first searched video can be played and paused after 10 seconds")
    public void TC2(){
        GoogleSearchedPage googleSearchedPage = new GoogleSearchedPage();
        YouTubePage youTubePage = new YouTubePage();

        //Step 1: Navigate to Google
        System.out.println("Step 1: Navigate to Google");
        googleSearchedPage.navigateToGoogle();

        //Step 2: Search with keyword
        System.out.println("Step 2: Search with keyword");
        googleSearchedPage.searchKeyWord(Constants.KEYWORD);

        //Step 3: Click on the first searched video
        System.out.println("Step 3: Click on the first searched video");

    }
}
