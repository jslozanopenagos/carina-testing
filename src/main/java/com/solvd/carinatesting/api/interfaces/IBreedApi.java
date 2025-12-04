package com.solvd.carinatesting.api.interfaces;

import com.zebrunner.carina.api.AbstractApiMethodV2;

public interface IBreedApi {

    String GET_BREEDS = "api/breed/_get";

    default AbstractApiMethodV2 getBreeds() {
        return new AbstractApiMethodV2(
                GET_BREEDS + "/rq.json",
                GET_BREEDS + "/rs.json",
                GET_BREEDS + "/rs.schema"
        ) {};
    }
}
