package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.BoxOfficePage;
import com.solvd.carinatesting.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopBoxOfficeTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "IMDB test")
    public void verifyTopBoxOfficeLoadsTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page did not load!");

        BoxOfficePage boxOfficePage = homePage.openTopBoxOffice();
        Assert.assertNotNull(boxOfficePage, "BoxOfficePage is null!");

        Assert.assertTrue(boxOfficePage.isLoaded(), "Box Office page did not load or has no items!");

        int count = boxOfficePage.getMoviesCount();
        Assert.assertTrue(count >= 1, "Expected at least 1 box office movies, found: " + count);

        boxOfficePage.getMoviesList().forEach(title ->
                Assert.assertFalse(title.isBlank(), "Movie title should not be blank!")
        );
    }
}