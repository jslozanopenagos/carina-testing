package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();

    public abstract void openEchoBox();
    public abstract void openLoginScreen();
    public abstract void openClipboardDemo();
    public abstract void openWebviewDemo();
    public abstract void openDualWindowDemo();
    public abstract void openListDemo();
    public abstract void openPhotoDemo();
    public abstract void openGeolocationDemo();
    public abstract void openPickerDemo();
    public abstract void openVerifyPhoneNumber();
}