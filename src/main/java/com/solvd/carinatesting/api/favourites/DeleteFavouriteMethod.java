package com.solvd.carinatesting.api.favourites;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${api_url}/v1/favourites/${id}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/favourites/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteFavouriteMethod extends AbstractApiMethodV2 {

    public DeleteFavouriteMethod(String favouriteId) {
        replaceUrlPlaceholder("api_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", favouriteId);
        setHeaders("x-api-key=" + Configuration.getRequired("api_key"));
    }
}