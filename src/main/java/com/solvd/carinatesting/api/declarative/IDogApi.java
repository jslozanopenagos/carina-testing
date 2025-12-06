package com.solvd.carinatesting.api.declarative;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.annotation.method.*;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url = "${base_url}")
public interface IDogApi {

    @GetMethod(url = "/breeds")
    @ResponseTemplatePath(path = "api/breed/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getBreeds();

    @GetMethod(url = "/images/search?limit=1")
    @ResponseTemplatePath(path = "api/images/_search/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 searchImages();

    @GetMethod(url = "/images/${id}")
    @ResponseTemplatePath(path = "api/images/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getImageById(@PathParam(key = "id") String id);

    @PostMethod(url = "/favourites")
    @RequestTemplatePath(path = "api/favourites/_post/rq.json")
    @ResponseTemplatePath(path = "api/favourites/_post/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
    AbstractApiMethodV2 postFavourite();

    @GetMethod(url = "/favourites")
    @ResponseTemplatePath(path = "api/favourites/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getFavourites();

    @DeleteMethod(url = "/favourites/${id}")
    @RequestTemplatePath(path = "api/favourites/_delete/rq.json")
    @ResponseTemplatePath(path = "api/favourites/_delete/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 deleteFavourite(@PathParam(key = "id") String id);
}