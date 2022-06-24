package TestCases;

import Constant.Constants;
import PageObjects.GoogleSearchedPage;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends TestBase {

    @Test(description = "TC1 - Validate results from Google Searched Page")
    public void TC1(){
        GoogleSearchedPage googleSearchedPage = new GoogleSearchedPage();

        //Step 1: Navigate to Google
        System.out.println("Step 1: Navigate to Google");
        googleSearchedPage.navigateToGoogle();

        //Step 2: Search with keyword
        System.out.println("Step 2: Search with keyword");
        googleSearchedPage.searchKeyWord(Constants.KEYWORD);

        //Step 3: Verify the main result on search result page
        System.out.println("Step 3: Verify the main result on search result page");
        Assert.assertEquals(googleSearchedPage.getMainResultText(), Constants.KEYWORD);

        //Step 4: Verify the search keyword at search bar
        System.out.println("Step 4: Verify the search keyword on the search bar");
        Assert.assertEquals(googleSearchedPage.getSearchInputKeyWord(), Constants.KEYWORD);

        googleSearchedPage.readVideoTitleArray();

        //Step 5: Verify the title of video section contains the query
        System.out.println("Step 5: Verify the title of video section contains the query");
        Assert.assertTrue(googleSearchedPage.isVideoText(),"The title of videos in section should contains '"+ Constants.KEYWORD + "' word");

        //Step 6: Verify the Top Stories contains the query
        System.out.println("Step 6: Verify the Top Stories contains the query");
        Assert.assertEquals(googleSearchedPage.isStoryText(), "The title of story in section should contains '"+ Constants.KEYWORD + "' word");

        //Step 7: Verify the People Also Ask contains the query
        System.out.println("Step 7: Verify the People Also Ask contains the query");
        Assert.assertEquals(googleSearchedPage.isPeopleAlsoAsk(), "The question in People Also Ask should contains '" + Constants.KEYWORD + "' word");

    }
}
