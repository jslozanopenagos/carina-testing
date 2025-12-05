package com.solvd.carinatesting.api.favourites;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/favourites", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/favourites/_post/rq.json")
@ResponseTemplatePath(path = "api/favourites/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostFavouriteMethod extends AbstractApiMethodV2 {

    public PostFavouriteMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setHeaders("x-api-key=" + Configuration.getRequired("api_key"));
    }
}