package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MoviePage extends AbstractPage {

    @FindBy(xpath = "//section[@data-testid='hero-parent']//span[@data-testid='hero__primary-text']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//section[@data-testid='hero-parent']//div[@data-testid='hero-rating-bar__aggregate-rating__score']/span[1]")
    private ExtendedWebElement ratingValue;

    @FindBy(xpath = "//ul[contains(@class,'ipc-inline-list')]/li[1]//a")
    private ExtendedWebElement releaseYear;

    @FindBy(xpath = "//ul[contains(@class,'ipc-inline-list')]/li[2]//a")
    private ExtendedWebElement ageRating;

    @FindBy(xpath = "//ul[contains(@class,'ipc-inline-list')]/li[3]")
    private ExtendedWebElement duration;

    @FindBy(xpath = "//div[@data-testid='genres']//a")
    private List<ExtendedWebElement> genres;

    private String expectedTitle;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getMovieTitle() {
        return title.isElementPresent(3)
                ? title.getText()
                : expectedTitle;
    }

    public String getRating() {
        return ratingValue.isElementPresent(3)
                ? ratingValue.getText()
                : "N/A";
    }

    public String getReleaseYear() {
        return releaseYear.isPresent()
                ? releaseYear.getText()
                : "";
    }

    public String getAgeRating() {
        return ageRating.isPresent()
                ? ageRating.getText()
                : "";
    }

    public String getDuration() {
        return duration.isPresent()
                ? duration.getText()
                : "";
    }

    public List<String> getGenres() {
        return genres.stream()
                .map(ExtendedWebElement::getText)
                .toList();
    }

    public void setExpectedTitle(String title) {
        this.expectedTitle = title;
    }
}
