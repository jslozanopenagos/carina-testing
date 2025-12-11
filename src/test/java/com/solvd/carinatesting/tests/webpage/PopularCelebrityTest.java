package com.solvd.carinatesting.tests.webpage;

import com.solvd.carinatesting.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PopularCelebrityTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "IMDB test")
    public void verifyPopularCelebrityNavigationTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page did not load!");

        CelebrityPage celebrityPage = homePage.openPopularCelebrity();
        Assert.assertNotNull(celebrityPage, "CelebrityPage did not open!");

        String firstCelebrityName = celebrityPage.getCelebrityName();
        Assert.assertFalse(firstCelebrityName.isBlank(), "Celebrity name should not be blank!");

        List<String> profileLinks = celebrityPage.getCelebrityProfileLinks();
        Assert.assertFalse(profileLinks.isEmpty(), "Celebrity profile links list should not be empty!");
        profileLinks.forEach(link ->
                Assert.assertTrue(link.contains("/name/"), "Profile link should contain '/name/': " + link)
        );

        List<String> rankings = celebrityPage.getCelebrityRankings();
        Assert.assertFalse(rankings.isEmpty(), "Celebrity rankings list should not be empty!");
        rankings.forEach(rank ->
                Assert.assertTrue(rank.startsWith("#"), "Ranking should start with #: " + rank)
        );
    }
}
