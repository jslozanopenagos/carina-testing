package com.solvd.carinatesting.gui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "suggestion-search")
    private ExtendedWebElement searchInput;

    @FindBy(id = "suggestion-search-button")
    private ExtendedWebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    public boolean isPageOpened() {
        return searchInput.isElementPresent();
    }

    public SearchResultsPage searchFor(String query) {
        searchInput.type(query);
        searchButton.scrollTo();
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }
}