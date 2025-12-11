package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.InTheatersPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InTheaterSectionTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(InTheaterSectionTest.class);

    @Test
    public void verifyInTheatersSection() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Homepage should be opened");

        InTheatersPage inTheatersPage = homePage.scrollToInTheatersSection();
        Assert.assertTrue(inTheatersPage.isPageOpened(), "In Theaters section should be displayed");
        LOGGER.info("Number of movies in theaters: {} ", inTheatersPage.getMoviesCount());
    }
}
