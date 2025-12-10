package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptySearchTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "imdb test")
    public void testEmptySearchShowsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page failed to open");

        homePage.searchFor("");

        Assert.assertTrue(homePage.isEmptySearchPageDisplayed(),
                "Expected empty search page, but it was not shown");
    }

}
