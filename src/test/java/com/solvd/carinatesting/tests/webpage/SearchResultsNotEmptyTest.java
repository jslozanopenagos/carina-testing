package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.SearchResultsPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsNotEmptyTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "imdb test")
    public void verifySearchReturnsResultsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page failed to open");

        SearchResultsPage resultsPage = homePage.searchFor("Inception");

        Assert.assertTrue(resultsPage.isPageOpened(), "Search results page not loaded");

        int count = resultsPage.getResultsCount();
        Assert.assertTrue(count > 0, "Expected at least 1 result, got " + count);
    }
}
