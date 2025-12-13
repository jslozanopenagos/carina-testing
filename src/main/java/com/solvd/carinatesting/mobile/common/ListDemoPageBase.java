package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ListDemoPageBase extends AbstractPage {
    public ListDemoPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();
    public abstract int getItemsCount();
    public abstract void clickRandomItem();
    public abstract void clickOkButton();
    public abstract void clickLearnMoreAboutButton();
    public abstract boolean isPopUpDisplayed();
}
