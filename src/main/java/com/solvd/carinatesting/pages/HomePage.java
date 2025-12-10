package com.solvd.carinatesting.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(id = "suggestion-search")
    private ExtendedWebElement searchInput;

    @FindBy(id = "suggestion-search-button")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@data-testid='subsection-title']//a[contains(@href,'/chart/boxoffice')]")
    private ExtendedWebElement topBoxOfficeLink;

    // Homepage sections
    @FindBy(xpath = "//div[contains(@class,'announcement-widget--title')]//h3[text()='Best Of 2025']")
    private ExtendedWebElement bestOf2025;

    @FindBy(xpath = "//div[contains(@class,'popular-celebrities-title')]//a")
    private ExtendedWebElement popularCelebrities;

    @FindBy(xpath = "//div[@data-testid='subsection-title']//a[contains(@href,'/what-to-watch/top-picks')]")
    private ExtendedWebElement topPicks;

    @FindBy(xpath = "//div[@data-testid='loader-container']//a[contains(@href,'/search/title/?moviemeter=%2C10')]")
    private ExtendedWebElement top10IMDb;

    @FindBy(xpath = "//div[@data-testid='feature-row-fan-picks']//a[contains(@href,'/what-to-watch/fan-favorites')]")
    private ExtendedWebElement fanFavorites;

    @FindBy(xpath = "//div[contains(@class,'ipc-title--subsection-title')]//a[contains(@href,'/interest/all/')]")
    private ExtendedWebElement popularInterests;

    @FindBy(xpath = "//div[@data-testid='feature-row-streaming-picks']//ul[@role='tablist']//li[@role='tab' and @aria-selected='true']")
    private ExtendedWebElement streamingPicksTab;

    @FindBy(xpath = "//div[@data-testid='subsection-title' and descendant::a[contains(@href,'/showtimes')]]")
    private ExtendedWebElement inTheaters;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    public boolean isPageOpened() {
        return searchInput.isElementPresent();
    }

    public SearchResultsPage searchFor(String query) {
        searchInput.type(query);
        searchButton.scrollTo();
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }

    public boolean isEmptySearchPageDisplayed() {
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl.contains("/find/?q=");
    }

    public BoxOfficePage openTopBoxOffice() {
        ExtendedWebElement[] sections = {bestOf2025, popularCelebrities, topPicks, top10IMDb, fanFavorites,
                popularInterests, streamingPicksTab, inTheaters};

        for (ExtendedWebElement section : sections) {
            if (section.isElementPresent()) {
                section.scrollTo();
            }
        }

        topBoxOfficeLink.waitUntil(ExpectedConditions.visibilityOf(topBoxOfficeLink.getElement()), 3);
        topBoxOfficeLink.waitUntil(ExpectedConditions.elementToBeClickable(topBoxOfficeLink.getElement()), 3);
        topBoxOfficeLink.scrollTo();
        topBoxOfficeLink.click();
        return new BoxOfficePage(getDriver());
    }

    public CelebrityPage openPopularCelebrity() {
        popularCelebrities.scrollTo();
        popularCelebrities.click();
        return new CelebrityPage(getDriver());
    }

    public TopPickPage openTopPick() {
        topPicks.scrollTo();
        topPicks.click();
        return new TopPickPage(getDriver());
    }

    public MovieDetailsPage openFanFavoriteMovie() {
        fanFavorites.scrollTo();
        fanFavorites.click();
        return new MovieDetailsPage(getDriver());
    }

    public MovieDetailsPage openInTheaterMovie() {
        inTheaters.scrollTo();
        inTheaters.click();
        return new MovieDetailsPage(getDriver());
    }
}