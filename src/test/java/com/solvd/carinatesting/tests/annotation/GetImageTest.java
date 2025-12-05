package com.solvd.carinatesting.tests.annotation;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.solvd.carinatesting.api.image.GetImageMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetImageTest implements IAbstractTest {

    private static final String SCHEMA_PATH = "api/images/_get/rs.schema";
    private static final String TEST_IMAGE_ID = "BJa4kxc4X"; // from theDogAPI docs

    @Test(testName = "Verify GET image endpoint")
    @MethodOwner(owner = "annotation-classic")
    public void verifyTestGetImageTest() {
        GetImageMethod getImage = new GetImageMethod(TEST_IMAGE_ID);
        Response rs = getImage.callAPIExpectSuccess();
        getImage.validateResponseAgainstSchema(SCHEMA_PATH);

        String id = rs.jsonPath().getString("id");
        assertEquals(id, TEST_IMAGE_ID, "Image ID must match the requested ID.");

        String url = rs.jsonPath().getString("url");
        assertNotNull(url, "Image URL should not be null.");
        assertTrue(url.startsWith("http"), "Image URL must start with http/https.");

        assertNotNull(rs.jsonPath().getList("breeds"), "Breeds must be a valid array.");
    }
}