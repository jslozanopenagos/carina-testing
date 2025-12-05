package com.solvd.carinatesting.tests.annotation;

import com.solvd.carinatesting.utils.ApiUtils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.solvd.carinatesting.api.favourites.GetFavouritesMethod;
import io.restassured.response.Response;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class GetFavouritesTest implements IAbstractTest {

    private static final String SCHEMA_PATH = "api/favourites/_get/rs.schema";

    @Test(testName = "Verify GET Favourites Endpoint")
    @MethodOwner(owner = "annotation-classic")
    public void verifyTestGetFavouritesTest() {
        if (ApiUtils.isFreeApiKey()) {
            throw new SkipException("Skipping test because free API key cannot perform this action.");
        }
        GetFavouritesMethod getFavourites = new GetFavouritesMethod();
        Response rs = getFavourites.callAPIExpectSuccess();

        getFavourites.validateResponseAgainstSchema(SCHEMA_PATH);

        List<Object> favourites = rs.jsonPath().getList("$");
        assertNotNull(favourites, "Favourites list should not be null");
        assertFalse(favourites.isEmpty(), "Favourites list should not be empty");

        Integer id = rs.jsonPath().getInt("[0].id");
        assertNotNull(id, "Favourite ID should not be null");

        String imageUrl = rs.jsonPath().getString("[0].image.url");
        assertNotNull(imageUrl, "Image URL should not be null");
        assertTrue(imageUrl.startsWith("http"), "Image URL must start with http/https");

        String createdAt = rs.jsonPath().getString("[0].created_at");
        assertNotNull(createdAt, "created_at field should not be null");
    }
}