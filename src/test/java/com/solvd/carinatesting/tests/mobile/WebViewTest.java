package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.solvd.carinatesting.mobile.common.WebViewPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(WebViewTest.class);

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyWebViewValidUrlTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());

        homePage.openWebviewDemo();

        WebViewPageBase webViewPage = initPage(WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page not opened");

        webViewPage.typeUrl("https://appiumpro.com");
        webViewPage.tapGoUrlButton();

        Assert.assertFalse(webViewPage.isWebAlertDisplayed(),
                "Web alert WAS displayed for a valid URL");
        LOGGER.info("verifyWebViewValidUrlTest passed");
    }

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyWebViewInValidUrlTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());

        homePage.openWebviewDemo();

        WebViewPageBase webViewPage = initPage(WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page not opened");

        webViewPage.typeUrl("https://appiumpro.c");
        webViewPage.tapGoUrlButton();
        Assert.assertTrue(webViewPage.isWebAlertDisplayed(), "Web alert was not displayed");
        LOGGER.info("verifyWebViewInValidUrlTest passed");
    }

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyClearButtonResetsUrlToDefaultTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened");

        homePage.openWebviewDemo();

        WebViewPageBase webViewPage = initPage(WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page not opened");

        String customUrl = "https://wrongurl.com";

        webViewPage.typeUrl(customUrl);

        Assert.assertTrue(
                webViewPage.isUrlDifferentFrom("https://appiumpro.com"),
                "URL should be different from default after typing"
        );

        webViewPage.tapClearButton();

        Assert.assertTrue(
                webViewPage.isUrlResetToDefault(),
                "URL was NOT reset to default after pressing Clear button"
        );
        LOGGER.info("verifyClearButtonResetsUrlToDefaultTest passed");
    }
}
