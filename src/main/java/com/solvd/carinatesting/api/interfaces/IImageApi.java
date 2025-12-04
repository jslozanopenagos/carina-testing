package com.solvd.carinatesting.api.interfaces;

import com.zebrunner.carina.api.AbstractApiMethodV2;

public interface IImageApi {

    String SEARCH_IMAGES = "api/image/_search";

    default AbstractApiMethodV2 searchImages() {
        return new AbstractApiMethodV2(
                SEARCH_IMAGES + "/rq.json",
                SEARCH_IMAGES + "/rs.json",
                SEARCH_IMAGES + "/rs.schema"
        ) {};
    }
}