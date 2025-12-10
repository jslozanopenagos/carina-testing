package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopPickPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class,'TitleHeader')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[contains(@class,'Summary')]")
    private ExtendedWebElement description;

    public TopPickPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }
}