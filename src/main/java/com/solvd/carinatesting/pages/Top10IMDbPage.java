package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Top10IMDbPage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class,'detailed-list-view')]/li")
    private List<ExtendedWebElement> top10Movies;

    public Top10IMDbPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return !top10Movies.isEmpty();
    }

    public int getMoviesCount() {
        return top10Movies.size();
    }
}