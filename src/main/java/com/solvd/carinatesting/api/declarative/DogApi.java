package com.solvd.carinatesting.api.declarative;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class DogApi implements IDogApi {

    @Override
    public AbstractApiMethodV2 getBreeds() {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/breed/_get/rq.json",
                "api/breed/_get/rs.json",
                "api/breed/_get/getBreeds.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return api;
    }

    @Override
    public AbstractApiMethodV2 searchImages() {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/images/_search//rq.json",
                "api/images/_search/rs.json",
                "api/images/_search/searchImages.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return api;
    }

    @Override
    public AbstractApiMethodV2 getImageById(String image_id) {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/images/_get/rq.json",
                "api/images/_get/rs.json",
                "api/images/_get/getImages.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        api.replaceUrlPlaceholder("image_id", image_id);
        return api;
    }

    @Override
    public AbstractApiMethodV2 postFavourite() {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/favourites/_post/rq.json",
                "api/favourites/_post/rs.json",
                "api/favourites/_post/postFavourites.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return api;
    }

    @Override
    public AbstractApiMethodV2 getFavourites() {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/favourites/_get/rq.json",
                "api/favourites/_get/rs.json",
                "api/favourites/_get/getFavourites.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return api;
    }

    @Override
    public AbstractApiMethodV2 deleteFavourite(String favouriteId) {
        AbstractApiMethodV2 api = new AbstractApiMethodV2(
                "api/favourites/_delete/rq.json",
                "api/favourites/_delete/rs.json",
                "api/favourites/deleteFavourites.properties"
        ) {};
        api.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        api.replaceUrlPlaceholder("favourite_id", favouriteId);
        return api;
    }
}