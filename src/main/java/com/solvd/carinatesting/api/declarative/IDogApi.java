package com.solvd.carinatesting.api.declarative;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.PathParam;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.annotation.method.DeleteMethod;
import com.zebrunner.carina.api.annotation.method.GetMethod;
import com.zebrunner.carina.api.annotation.method.PostMethod;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url = "${base_url}")
public interface IDogApi {

    @GetMethod(url = "/v1/breeds")
    @ResponseTemplatePath(path = "api/breed/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getBreeds();

    @GetMethod(url = "/v1/favourites")
    @ResponseTemplatePath(path = "api/favourites/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getFavourites();

    @PostMethod(url = "/favourites")
    @RequestTemplatePath(path = "api/favourites/_post/rq.json")
    @ResponseTemplatePath(path = "api/favourites/_post/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
    AbstractApiMethodV2 postFavourite();

    @DeleteMethod(url = "/v1/favourites/${id}")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
    AbstractApiMethodV2 deleteFavourite(@PathParam(key = "id") String favouriteId);

    @GetMethod(url = "/v1/images/${id}")
    @ResponseTemplatePath(path = "api/image/_get_by_id/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getImageById(@PathParam(key = "id") String imageId);
}
