package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends AbstractPage {

    public LoginScreenBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();
    public abstract void typeUsername(String username);
    public abstract void typePassword(String password);
    public abstract void tapLoginButton();
    public abstract boolean isErrorMessagePresent();
}
