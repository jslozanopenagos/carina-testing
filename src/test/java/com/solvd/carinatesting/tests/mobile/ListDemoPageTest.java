package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.solvd.carinatesting.mobile.common.ListDemoPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListDemoPageTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(ListDemoPageTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyClickOnRandomListDemoPageElementTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.openListDemo();

        ListDemoPageBase listDemoPage = initPage(ListDemoPageBase.class);
        Assert.assertTrue(listDemoPage.isPageOpened(), "ListDemoPage is not opened");

        Assert.assertTrue(
                listDemoPage.getItemsCount() > 0,
                "List Demo page should contain at least one item"
        );

        listDemoPage.clickRandomItem();
        listDemoPage.clickOkButton();
        LOGGER.info("OK button was clicked successfully");
    }

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyClickOnLearnMoreAboutButtonTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.openListDemo();

        ListDemoPageBase listDemoPage = initPage(ListDemoPageBase.class);
        Assert.assertTrue(listDemoPage.isPageOpened(), "ListDemoPage is not opened");

        Assert.assertTrue(
                listDemoPage.getItemsCount() > 0,
                "List Demo page should contain at least one item"
        );

        listDemoPage.clickRandomItem();
        listDemoPage.clickLearnMoreAboutButton();
        LOGGER.info("Learn More About button was clicked successfully");

    }
}
