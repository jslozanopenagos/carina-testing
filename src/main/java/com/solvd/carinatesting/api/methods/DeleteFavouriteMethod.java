package com.solvd.carinatesting.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class DeleteFavouriteMethod extends AbstractApiMethodV2 {

    public DeleteFavouriteMethod() {
        super("api/favourites/_delete/rq.json",
                "api/favourites/_delete/rs.json");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}