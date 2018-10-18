package com.playground.nutrition.data.remote;

import com.playground.nutrition.AppExecutors;
import com.playground.nutrition.data.entities.ResponseRecipesRequest;

import java.io.IOException;

import retrofit2.Callback;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class RemoteDataSource {

    private RecipeServiceAPI service;

    public RemoteDataSource(RecipeServiceAPI serviceAPI) {
        service = serviceAPI;
    }

    public void searchQuery(String searchQuery, int page, Callback<ResponseRecipesRequest> callback) {
        AppExecutors.getInstance().networkIO().execute(() -> {
            try {
                callback.onResponse(service.searchQuery(searchQuery, page), service.searchQuery(searchQuery, page).execute());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
