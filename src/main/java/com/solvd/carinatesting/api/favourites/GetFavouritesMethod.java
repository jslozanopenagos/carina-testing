package com.solvd.carinatesting.api.favourites;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${api_url}/v1/favourites", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/favourites/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetFavouritesMethod extends AbstractApiMethodV2 {

    public GetFavouritesMethod() {
        replaceUrlPlaceholder("api_url", Configuration.getRequired("api_url"));
        setHeaders("x-api-key=" + Configuration.getRequired("api_key"));
    }
}