package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();
    public abstract void typeUrl(String url);
    public abstract void tapGoUrlButton();
    public abstract boolean isWebAlertDisplayed();
    public abstract void tapClearButton();
    public abstract boolean isUrlResetToDefault();
    public abstract boolean isUrlDifferentFrom(String value);
}
