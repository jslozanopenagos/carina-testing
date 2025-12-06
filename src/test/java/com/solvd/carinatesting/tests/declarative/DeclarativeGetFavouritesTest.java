package com.solvd.carinatesting.tests.declarative;

import com.solvd.carinatesting.api.declarative.IDogApi;
import com.solvd.carinatesting.utils.ApiUtils;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class DeclarativeGetFavouritesTest implements IAbstractTest {

    @Test(description = "Declarative test: GET /favourites retrieves all favourites")
    @MethodOwner(owner = "declarative-test")
    public void verifyGetFavouriteTest() {
        if (ApiUtils.isFreeApiKey()) {
            throw new SkipException("Skipping test because free API key cannot perform this action.");
        }

        IDogApi apiTemplate = TemplateFactory.prepareTemplate(IDogApi.class);
        AbstractApiMethodV2 apiMethod = apiTemplate.getFavourites();
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponse();
    }
}
