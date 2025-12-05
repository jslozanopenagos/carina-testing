package com.solvd.carinatesting.tests.annotation;

import com.solvd.carinatesting.api.favourites.DeleteFavouriteMethod;
import com.solvd.carinatesting.api.favourites.PostFavouriteMethod;
import com.solvd.carinatesting.utils.ApiUtils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DeleteFavouriteTest implements IAbstractTest {

    private static final String SCHEMA_PATH = "api/favourites/_delete/rs.schema";

    @Test(testName = "Verify DELETE favourite with id functionality")
    @MethodOwner(owner = "annotation-classic")
    public void verifyDeleteFavouriteTest() {
        if (ApiUtils.isFreeApiKey()) {
            throw new SkipException("Skipping test because free API key cannot perform this action.");
        }

        // Creation of a favourite
        PostFavouriteMethod postFavourite = new PostFavouriteMethod();
        Response postRs = postFavourite.callAPIExpectSuccess();

        Integer favouriteId = postRs.jsonPath().getInt("id");
        assertNotNull(favouriteId, "Favourite ID should not be null after creation.");

        // Deletion of the created favourite
        DeleteFavouriteMethod deleteFavourite =
                new DeleteFavouriteMethod(String.valueOf(favouriteId));

        Response deleteRs = deleteFavourite.callAPIExpectSuccess();
        deleteFavourite.validateResponseAgainstSchema(SCHEMA_PATH);

        String message = deleteRs.jsonPath().getString("message");
        assertEquals(message, "SUCCESS", "Delete response message should be SUCCESS.");
    }
}
