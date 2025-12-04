package com.solvd.carinatesting.api.interfaces;

import com.zebrunner.carina.api.AbstractApiMethodV2;

public interface IFavouriteApi {

    String GET_FAVOURITES = "api/favourites/_get";
    String POST_FAVOURITE = "api/favourites/_post";
    String DELETE_FAVOURITE = "api/favourites/_delete";

    default AbstractApiMethodV2 getFavourites() {
        return new AbstractApiMethodV2(
                GET_FAVOURITES + "/rq.json",
                GET_FAVOURITES + "/rs.json",
                GET_FAVOURITES + "/rs.schema"
        ) {};
    }

    default AbstractApiMethodV2 postFavourite() {
        return new AbstractApiMethodV2(
                POST_FAVOURITE + "/rq.json",
                POST_FAVOURITE + "/rs.json",
                POST_FAVOURITE + "/postFavourite.properties"
        ) {};
    }

    default AbstractApiMethodV2 deleteFavourite() {
        return new AbstractApiMethodV2(
                DELETE_FAVOURITE + "/rq.json",
                DELETE_FAVOURITE + "/rs.json",
                POST_FAVOURITE + "/postFavourite.properties"
        ) {};
    }
}

