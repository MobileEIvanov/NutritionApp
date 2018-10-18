package com.playground.nutrition.data.remote;

import com.playground.nutrition.BuildConfig;
import com.playground.nutrition.data.entities.ResponseRecipesRequest;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public interface RecipeServiceAPI {

    @GET("/get?key=" + BuildConfig.SERVICE_API_KEY)
    Call<ResponseRecipesRequest> queryAll();

}
