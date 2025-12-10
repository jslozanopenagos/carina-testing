package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.HomePage;
import com.solvd.carinatesting.pages.MoviePage;
import com.solvd.carinatesting.pages.SearchResultsPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieMetadataTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "imdb test")
    public void verifyMovieRatingTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page did not open!");

        SearchResultsPage results = homePage.searchFor("Interstellar");
        Assert.assertTrue(results.hasResults(), "Search returned no results!");

        MoviePage movie = results.openFirstResult();

        Assert.assertTrue(
                movie.getMovieTitle().toLowerCase().contains("interstellar"),
                "Movie title mismatch!"
        );

        String rating = movie.getRating();
        Assert.assertNotEquals(rating, "N/A", "Movie rating was not found!");

        // Regex checks IMDb rating must be numeric like "8.7" or "8,7", depends on language
        Assert.assertTrue(
                rating.matches("\\d+([.,]\\d+)?"),
                "Rating is not a valid number! Found: " + rating
        );
    }
}