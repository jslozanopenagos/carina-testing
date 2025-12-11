package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FanFavoritesPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'ipc-poster-card')]")
    private List<ExtendedWebElement> movieCards;

    public FanFavoritesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return !movieCards.isEmpty() && movieCards.get(0).isElementPresent();
    }
}
