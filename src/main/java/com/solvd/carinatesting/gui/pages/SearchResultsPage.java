package com.solvd.carinatesting.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//section[contains(@data-testid,'find-results')]//ul//li")
    private List<ExtendedWebElement> resultItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getResultsCount() {
        return resultItems.size();
    }

    public boolean hasResults() {
        return !resultItems.isEmpty();
    }

    public List<String> getAllTitles() {
        return resultItems.stream()
                .map(this::extractTitle)
                .collect(Collectors.toList());
    }

    private String extractTitle(ExtendedWebElement li) {
        ExtendedWebElement title =
                li.findExtendedWebElement(By.xpath(".//h3[@class='ipc-title__text']"));

        return title.getText();
    }

    public MoviePage openFirstResult() {
        return openResultByIndex(0);
    }

    public MoviePage openResultByIndex(int index) {
        ExtendedWebElement li = resultItems.get(index);

        String movieTitle = extractTitle(li);

        ExtendedWebElement clickable =
                li.findExtendedWebElement(By.xpath(".//a[contains(@class,'ipc-title-link-wrapper')]"));

        clickable.click();

        MoviePage moviePage = new MoviePage(getDriver());
        moviePage.setExpectedTitle(movieTitle);
        return moviePage;
    }
}