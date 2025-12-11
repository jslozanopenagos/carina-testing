package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InTheatersPage extends AbstractPage {

    @FindBy(xpath = "//ul[@data-testid='movies-near-you-list']/li")
    private List<ExtendedWebElement> inTheatersMovies;

    public InTheatersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return !inTheatersMovies.isEmpty();
    }

    public int getMoviesCount() {
        return inTheatersMovies.size();
    }
}
