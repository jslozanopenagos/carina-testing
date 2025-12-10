package com.solvd.carinatesting.tests.api.annotation;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.solvd.carinatesting.api.image.SearchImagesMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SearchImagesTest implements IAbstractTest {

    private static final String SCHEMA_PATH = "api/images/_search/rs.schema";

    @Test(testName = "Verify SEARCH images endpoint")
    @MethodOwner(owner = "annotation-classic")
    public void verifyTestSearchImagesTest() {

        SearchImagesMethod searchImages = new SearchImagesMethod();
        Response rs = searchImages.callAPIExpectSuccess();
        searchImages.validateResponseAgainstSchema(SCHEMA_PATH);

        List<Map<String, Object>> images = rs.jsonPath().getList("$");
        assertNotNull(images, "Images list should not be null");
        assertFalse(images.isEmpty(), "Images list should not be empty");

        Map<String, Object> firstImage = images.get(0);
        assertNotNull(firstImage.get("id"), "Image ID should not be null");
        assertNotNull(firstImage.get("url"), "Image URL should not be null");
        assertTrue(firstImage.get("url").toString().startsWith("http"), "Image URL must start with http/https");
    }
}
