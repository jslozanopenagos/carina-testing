package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.FanFavoritesPage;
import com.solvd.carinatesting.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FanFavoriteNavigationTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(FanFavoriteNavigationTest.class);

    @Test
    @MethodOwner(owner = "IMDB test")
    public void verifyFanFavoriteNavigationTest() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page should be opened");

        FanFavoritesPage fanFav = home.openFanFavoritesSection();
        Assert.assertTrue(fanFav.isPageOpened(), "Fan Favorites page should be opened");

        LOGGER.info("Fan Favorites section successfully opened!");
    }
}
