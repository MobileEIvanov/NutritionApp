package com.playground.nutrition.data.remote;

import com.playground.nutrition.BuildConfig;
import com.playground.nutrition.data.entities.ResponseRecipesRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public interface RecipeServiceAPI {

    @GET("api/?")
    Call<ResponseRecipesRequest> searchQuery(@Query("q") String searchQuery, @Query("p") int page);

}
