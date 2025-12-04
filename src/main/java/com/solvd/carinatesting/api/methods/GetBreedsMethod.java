package com.solvd.carinatesting.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class GetBreedsMethod extends AbstractApiMethodV2 {

    public GetBreedsMethod() {
        super("api/breed/_get/rq.json",
                "api/breed/_get/rs.json",
                "api/breed/_get/rs.schema");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
