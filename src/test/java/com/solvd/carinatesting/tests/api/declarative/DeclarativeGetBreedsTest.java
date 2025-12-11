package com.solvd.carinatesting.tests.api.declarative;

import com.solvd.carinatesting.api.declarative.IDogApi;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class DeclarativeGetBreedsTest implements IAbstractTest {

    @Test(description = "Declarative test: GET /breeds retrieves list of breeds")
    @MethodOwner(owner = "declarative-test")
    public void verifyGetBreedsTest() {
        IDogApi apiTemplate = TemplateFactory.prepareTemplate(IDogApi.class);
        AbstractApiMethodV2 apiMethod = apiTemplate.getBreeds();
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }
}
