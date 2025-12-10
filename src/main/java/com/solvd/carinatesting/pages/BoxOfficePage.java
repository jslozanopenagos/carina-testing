package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BoxOfficePage extends AbstractPage {

    @FindBy(xpath = "//div[@data-testid='chart-layout-main-column']//li[contains(@class,'ipc-metadata-list-summary-item')]")
    private List<ExtendedWebElement> boxOfficeMovies;

    public BoxOfficePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return boxOfficeMovies != null && !boxOfficeMovies.isEmpty();
    }

    public int getMoviesCount() {
        return boxOfficeMovies.size();
    }

    public List<String> getMoviesList() {
        return boxOfficeMovies.stream()
                .map(item -> item.findExtendedWebElement(
                        By.xpath(".//h3[contains(@class,'ipc-title__text')]")
                ).getText())
                .toList();
    }
}
