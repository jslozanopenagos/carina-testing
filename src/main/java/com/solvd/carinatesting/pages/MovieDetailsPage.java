package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MovieDetailsPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class,'TitleHeader')]")
    private ExtendedWebElement movieTitle;

    @FindBy(xpath = "//span[contains(@class,'AggregateRating')]")
    private ExtendedWebElement rating;

    @FindBy(xpath = "//span[contains(@class,'Summary')]")
    private ExtendedWebElement summary;

    public MovieDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getMovieTitle() {
        return movieTitle.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getSummary() {
        return summary.getText();
    }
}