package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.solvd.carinatesting.mobile.common.LoginScreenBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogintPageTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(LogintPageTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyInvalidLoginTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened!");

        homePage.openLoginScreen();

        LoginScreenBase loginScreen = initPage(getDriver(), LoginScreenBase.class);
        Assert.assertTrue(loginScreen.isPageOpened(), "Login screen not opened!");

        loginScreen.typeUsername("invalidUser");
        loginScreen.typePassword("wrongPassword");

        loginScreen.tapLoginButton();

        Assert.assertTrue(loginScreen.isErrorMessagePresent(),
                "Error message was NOT displayed after invalid login attempt!");

        LOGGER.info("Invalid login test passed!");

    }

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyValidLoginTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened!");

        homePage.openLoginScreen();

        LoginScreenBase loginScreen = initPage(getDriver(), LoginScreenBase.class);
        Assert.assertTrue(loginScreen.isPageOpened(), "Login screen not opened!");

        loginScreen.typeUsername("myuser");
        loginScreen.typePassword("mypassword");
        loginScreen.tapLoginButton();
        LOGGER.info("Successfully logged in!");
    }

}
