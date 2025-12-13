package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EchoPageBase extends AbstractPage {
    public EchoPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();

    public abstract void typeMessage(String message);
    public abstract void tapEchoButton();
    public abstract boolean isMessageDisplayed();
}
