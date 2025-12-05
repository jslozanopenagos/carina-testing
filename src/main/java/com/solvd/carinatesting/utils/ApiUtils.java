package com.solvd.carinatesting.utils;

import com.zebrunner.carina.utils.config.Configuration;

public class ApiUtils {
    public static boolean isFreeApiKey() {
        String apiKey = Configuration.getRequired("api_key");
        return apiKey.startsWith("live_");
    }
}
