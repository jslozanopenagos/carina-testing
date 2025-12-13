package com.solvd.carinatesting.tests.mobile;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.solvd.carinatesting.mobile.common.WebViewPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyWebViewValidUrlTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());

        homePage.openWebviewDemo();

        WebViewPageBase webViewPage = initPage(WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened());

        webViewPage.typeUrl("https://appiumpro.com");
        webViewPage.tapGoUrlbutton();

        Assert.assertFalse(webViewPage.isWebAlertDisplayed(),
                "Web alert WAS displayed for a valid URL");
    }

    @Test
    @MethodOwner(owner = "TheApp mobile android test")
    public void verifyWebViewInValidUrlTest(){
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());

        homePage.openWebviewDemo();

        WebViewPageBase webViewPage = initPage(WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened());

        webViewPage.typeUrl("https://appiumpro.c");
        webViewPage.tapGoUrlbutton();
        Assert.assertTrue(webViewPage.isWebAlertDisplayed(), "Web alert was not displayed");
    }
}
