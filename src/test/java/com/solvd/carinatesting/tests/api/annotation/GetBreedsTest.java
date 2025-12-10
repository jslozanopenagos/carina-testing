package com.solvd.carinatesting.tests.api.annotation;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.solvd.carinatesting.api.breed.GetBreedsMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class GetBreedsTest implements IAbstractTest {
    private static final String SCHEMA_PATH = "api/breed/_get/rs.schema";

    @Test(testName = "Verify GET breeds endpoint response schema")
    @MethodOwner(owner = "annotation-classic")
    public void verifyTestGetBreedsTest() {
        GetBreedsMethod getBreeds = new GetBreedsMethod();
        Response rs = getBreeds.callAPIExpectSuccess();
        getBreeds.validateResponseAgainstSchema(SCHEMA_PATH);

        // JSONPath validations
        List<Object> breeds = rs.jsonPath().getList("$");
        assertFalse(breeds.isEmpty(), "Breeds list should not be empty");

        Integer id = rs.jsonPath().getInt("[0].id");
        assertNotNull(id);
    }
}