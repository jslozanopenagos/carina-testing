package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyHomePageIsOpenedTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is NOT opened!");
        LOGGER.info("Home page is opened!");
    }
}