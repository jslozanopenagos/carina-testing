package com.solvd.carinatesting.tests.annotation;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import com.solvd.carinatesting.api.breed.GetBreedsMethod;
import com.solvd.carinatesting.api.favourites.GetFavouritesMethod;
import com.solvd.carinatesting.api.favourites.PostFavouriteMethod;
import com.solvd.carinatesting.api.favourites.DeleteFavouriteMethod;
import com.solvd.carinatesting.api.image.GetImageMethod;

import static org.hamcrest.Matchers.equalTo;

public class AnnotationDogApiTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "annotation-classic")
    public void testGetBreedsClassic() {
        GetBreedsMethod api = new GetBreedsMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/breeds/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "annotation-classic")
    public void testGetFavouritesClassic() {
        GetFavouritesMethod api = new GetFavouritesMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/favourites/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "annotation-classic")
    public void testPostFavouriteClassic() {
        PostFavouriteMethod post = new PostFavouriteMethod();
        post.callAPIExpectSuccess();
        post.validateResponseAgainstSchema("api/favourites/_post/rs.schema");
        post.getResponse().getResponse().then().body("message", equalTo("SUCCESS"));
    }

    @Test
    @MethodOwner(owner = "annotation-classic")
    public void testDeleteFavouriteClassic() {
        // create favourite
        PostFavouriteMethod post = new PostFavouriteMethod();
        post.callAPIExpectSuccess();
        int id = post.getResponse().getResponse().jsonPath().getInt("id");

        // delete
        DeleteFavouriteMethod delete = new DeleteFavouriteMethod(String.valueOf(id));
        delete.callAPIExpectSuccess();
    }

    @Test
    @MethodOwner(owner = "annotation-classic")
    public void testGetImageClassic() {
        // Use a known image id or create an image via search then use its id
        GetImageMethod api = new GetImageMethod("BJa4kxc4X");
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/images/_get/rs.schema");
    }
}
