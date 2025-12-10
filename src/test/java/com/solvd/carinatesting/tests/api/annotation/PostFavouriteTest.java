package com.solvd.carinatesting.tests.api.annotation;

import com.solvd.carinatesting.utils.ApiUtils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.solvd.carinatesting.api.favourites.PostFavouriteMethod;
import io.restassured.response.Response;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PostFavouriteTest implements IAbstractTest {

    private static final String SCHEMA_PATH = "api/favourites/_post/rs.schema";

    @Test(testName = "Verify POST Favourite Endpoint")
    @MethodOwner(owner = "annotation-classic")
    public void verifyTestPostFavouriteTest() {
        if (ApiUtils.isFreeApiKey()) {
            throw new SkipException("Skipping test because free API key cannot perform this action.");
        }

        PostFavouriteMethod postFavourite = new PostFavouriteMethod();
        Response rs = postFavourite.callAPIExpectSuccess();
        postFavourite.validateResponseAgainstSchema(SCHEMA_PATH);

        String message = rs.jsonPath().getString("message");
        assertEquals(message, "SUCCESS", "Response message must be SUCCESS.");

        int id = rs.jsonPath().getInt("id");
        assertTrue(id > 0, "Returned favourite ID must be a positive number.");
    }
}