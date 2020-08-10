package com.daniil.mediplayer;

public class APIUtils {
    public static final String BASE_URL = "https://www.fdy-music.com/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
