package com.solvd.carinatesting.mobile.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PhotoDemoPageBase extends AbstractPage {
    public PhotoDemoPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isPageOpened();
    public abstract int getItemsCount();
    public abstract void selectRandomPhoto();
    public abstract void clickPopUpOkButton();
    public abstract boolean isPopUpDisplayed();
}
