package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.Top10IMDbPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Top10IMDbSectionTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(Top10IMDbSectionTest.class);

    @Test
    @MethodOwner(owner = "IMDB test")
    public void verifyTop10IMDbNavigation() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Homepage should be opened");

        Top10IMDbPage top10Page = home.scrollToTop10IMDb();
        Assert.assertTrue(top10Page.isPageOpened(), "Top 10 IMDb page should be opened");
        LOGGER.info("Top 10 IMDb page is successfully opened");
    }
}