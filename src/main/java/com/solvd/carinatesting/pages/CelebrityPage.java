package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CelebrityPage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class,'compact-list-view')]/li")
    private List<ExtendedWebElement> celebrities;

    public CelebrityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return celebrities != null && !celebrities.isEmpty();
    }

    public List<String> getCelebrityNames() {
        return celebrities.stream()
                .map(celeb -> celeb.findExtendedWebElement(By.xpath(".//h3[contains(@class,'ipc-title__text')]")).getText())
                .collect(Collectors.toList());
    }

    public List<String> getCelebrityProfileLinks() {
        return celebrities.stream()
                .map(celeb -> celeb.findExtendedWebElement(By.xpath(".//a[contains(@href,'/name/')]")).getAttribute("href"))
                .collect(Collectors.toList());
    }

    public List<String> getCelebrityRankings() {
        return celebrities.stream()
                .map(celeb -> celeb.findExtendedWebElement(By.xpath(".//div[@data-testid='nlib-ranking']/div")).getText())
                .collect(Collectors.toList());
    }

    public String getCelebrityName() {
        if (isLoaded()) {
            return getCelebrityNames().get(0);
        }
        return "";
    }
}