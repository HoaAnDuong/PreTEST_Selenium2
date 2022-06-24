package TestCases;

import Constant.Constants;
import PageObjects.GoogleSearchedPage;
import PageObjects.YouTubePage;
import TestBase.TestBase;
import org.testng.Assert;
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

        //Step 3: Get first video title
        System.out.println("Step 3: Get first video title");
        String firstVideoTitle = googleSearchedPage.readVideoTitleArray()[0];

        //Step 4: Click on the first searched video
        System.out.println("Step 4: Click on the first searched video");
        googleSearchedPage.clickFirstVideo(Constants.KEYWORD);

        //Step 5: Play and Pause video after 10s
        System.out.println("Step 6: Play and Pause video after 10s");
        youTubePage.pauseVideoAfter("0:10");

        //Step 6: Verify the title of first video on YouTube page
        System.out.println("Step 5: Verify the title of first video on YouTube page");
        Assert.assertEquals(youTubePage.getVideoTitle(), firstVideoTitle, "The title of video should contain '" + Constants.KEYWORD +"' word");

        //Step 7: Verify video is paused accordingly
        System.out.println("Step 5: Verify the title of first video on YouTube page");
        Assert.assertFalse(youTubePage.isVideoPlay(), "The video isn't paused");


    }
}
