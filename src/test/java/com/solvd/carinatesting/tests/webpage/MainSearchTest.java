package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.SearchResultsPage;
import com.solvd.carinatesting.pages.MoviePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainSearchTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "imdb test")
    public void verifySearchAndOpenMovieTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchResultsPage results = homePage.searchFor("Inception");

        Assert.assertTrue(results.hasResults(), "No results found!");

        MoviePage movie = results.openFirstResult();

        Assert.assertTrue(
                movie.getMovieTitle().contains("Inception"),
                "Movie title mismatch! Expected Inception."
        );
    }
}
