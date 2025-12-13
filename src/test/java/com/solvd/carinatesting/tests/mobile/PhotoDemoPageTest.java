package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.solvd.carinatesting.mobile.common.PhotoDemoPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotoDemoPageTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(PhotoDemoPageTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyElementsPhotoDemoPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());

        homePage.openPhotoDemo();

        PhotoDemoPageBase photoDemoPageBase = initPage(getDriver(), PhotoDemoPageBase.class);
        Assert.assertTrue(photoDemoPageBase.isPageOpened());

        Assert.assertTrue(
                photoDemoPageBase.getItemsCount() > 0,
                "Photo Demo page should have at least one item"
        );

        photoDemoPageBase.selectRandomPhoto();
        photoDemoPageBase.clickPopUpOkButton();
        LOGGER.info("Random photo of Photo Demo page was clicked");
    }
}