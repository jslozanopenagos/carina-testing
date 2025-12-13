package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.EchoPageBase;
import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EchoPageTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(EchoPageTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyEchoPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened");

        homePage.openEchoBox();

        EchoPageBase echoPage = initPage(getDriver(), EchoPageBase.class);
        Assert.assertTrue(echoPage.isPageOpened(), "Echo page is not opened");

        echoPage.typeMessage("Hi world!");
        echoPage.tapEchoButton();

        Assert.assertTrue(echoPage.isMessageDisplayed(), "Echo message is not displayed");

        LOGGER.info("Echo message displayed");
    }
}
