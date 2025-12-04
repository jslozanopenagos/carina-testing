package com.solvd.carinatesting.api.favourites;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PostFavouriteMethod extends AbstractApiMethodV2 {

    public PostFavouriteMethod() {
        super("api/favourites/_post/rq.json",
                "api/favourites/_post/rs.json");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}

