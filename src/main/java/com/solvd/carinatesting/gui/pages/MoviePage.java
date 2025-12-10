package com.solvd.carinatesting.gui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends AbstractPage {

    @FindBy(xpath = "//section[@data-testid='hero-parent']//span[@data-testid='hero__primary-text']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//section[@data-testid='hero-parent']//div[@data-testid='hero-rating-bar__aggregate-rating__score']/span[1]")
    private ExtendedWebElement ratingValue;


    private String expectedTitle;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public void setExpectedTitle(String title) {
        this.expectedTitle = title;
    }

    public String getMovieTitle() {
        return title.isElementPresent(3) ? title.getText() : expectedTitle;
    }

    public String getRating() {
        return ratingValue.isElementPresent(3) ? ratingValue.getText() : "N/A";
    }
}

