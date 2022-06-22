package TestCases;

import Constant.Constants;
import PageObjects.GoogleSearchedPage;
import TestBase.TestBase;
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
        googleSearchedPage.inputSearchBox(Constants.KEYWORD);
    }
}
