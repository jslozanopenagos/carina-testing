package com.solvd.carinatesting.api.image;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class SearchImagesMethod extends AbstractApiMethodV2 {

    public SearchImagesMethod() {
        super("api/image/_search/rq.json",
                "api/image/_search/rs.json",
                "api/image/_search/rs.schema");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}

