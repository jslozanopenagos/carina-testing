package com.solvd.carinatesting.tests.api.declarative;

import com.solvd.carinatesting.api.declarative.IDogApi;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.Test;

public class DeclarativeSearchImagesTest implements IAbstractTest {

    @Test(description = "Declarative test: GET /images/search retrieves images")
    @MethodOwner(owner = "declarative-test")
    public void verifySearchImagesTest() {
        IDogApi apiTemplate = TemplateFactory.prepareTemplate(IDogApi.class);
        AbstractApiMethodV2 apiMethod = apiTemplate.searchImages();
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponseAgainstSchema("api/images/_search/rs.schema");
    }
}
