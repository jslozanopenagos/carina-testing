package com.solvd.carinatesting.tests.api.declarative;

import com.solvd.carinatesting.api.declarative.IDogApi;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.Test;

public class DeclarativeGetImageTest implements IAbstractTest {

    @Test(description = "Declarative test: GET /images/{id} retrieves image info")
    @MethodOwner(owner = "declarative-test")
    public void verifyGetImageTest() {
        IDogApi apiTemplate = TemplateFactory.prepareTemplate(IDogApi.class);
        AbstractApiMethodV2 apiMethod = apiTemplate.getImageById("BJa4kxc4X");
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponse();
    }
}