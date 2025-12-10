package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CelebrityPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class,'header')]")
    private ExtendedWebElement celebrityName;

    @FindBy(xpath = "//div[contains(@class,'bio')]")
    private ExtendedWebElement biography;

    public CelebrityPage(WebDriver driver) {
        super(driver);
    }

    public String getCelebrityName() {
        return celebrityName.getText();
    }

    public String getBiographySnippet() {
        return biography.getText();
    }
}