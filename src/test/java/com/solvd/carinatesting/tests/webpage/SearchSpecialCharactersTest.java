package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.SearchResultsPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSpecialCharactersTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "imdb test")
    public void verifySearchSpecialCharactersTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page failed to open");

        SearchResultsPage resultsPage = homePage.searchFor("@@@@@@");

        Assert.assertTrue(resultsPage.isNoResultsPage(),
                "Search results page not loaded correctly for special characters");

        int count = resultsPage.getResultsCount();
        Assert.assertEquals(count, 0, "Expected 0 results for special characters, but found " + count);
    }
}
