package com.playground.nutrition.data.entities;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class ResponseRecipesWrapper {

    private LiveData<PagedList<Recipe>> data;
    private LiveData<String> networkError;

    public ResponseRecipesWrapper(LiveData<PagedList<Recipe>> data, LiveData<String> networkError) {
        this.data = data;
        this.networkError = networkError;
    }

    public LiveData<PagedList<Recipe>> getData() {
        return data;
    }

    public LiveData<String> getNetworkError() {
        return networkError;
    }
}
