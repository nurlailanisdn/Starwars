package com.example.starwars.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/api/planets/")
    Call<Result> showPlanets();
}
