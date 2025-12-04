package com.solvd.carinatesting.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class GetFavouritesMethod extends AbstractApiMethodV2 {

    public GetFavouritesMethod() {
        super("api/favourites/_get/rq.json",
                "api/favourites/_get/rs.json",
                "api/favourites/_get/rs.schema");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
