package com.playground.nutrition.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.playground.nutrition.data.db.LocalDataSource;
import com.playground.nutrition.data.remote.RemoteDataSource;
import com.playground.nutrition.data.entities.ResponseRecipesRequest;
import com.playground.nutrition.entities.Recipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emil.ivanov on 10/17/18.
 */
class DataBoudnaryCallback extends PagedList.BoundaryCallback<Recipe> {

    public static final int NETWORK_PAGE_SIZE = 50;
    private static final String DEFAULT_NETWORK_ERROR = "Failed to retrieve data";
    private RemoteDataSource service;
    private LocalDataSource database;
    private MutableLiveData<String> _networkErrors = new MutableLiveData<>();

    public DataBoudnaryCallback(RemoteDataSource service, LocalDataSource database) {
        this.service = service;
        this.database = database;
    }


    @Override
    public void onItemAtEndLoaded(@NonNull Recipe itemAtEnd) {
        requestAndSaveData();
    }

    @Override
    public void onZeroItemsLoaded() {
        requestAndSaveData();
    }


    private void requestAndSaveData() {
        service.queryAll(new Callback<ResponseRecipesRequest>() {
            @Override
            public void onResponse(Call<ResponseRecipesRequest> call, Response<ResponseRecipesRequest> response) {
                if (response.isSuccessful()) {
                    ResponseRecipesRequest responseRecipesRequest = response.body();
                    if (responseRecipesRequest != null) {
                        database.insert(responseRecipesRequest.getListData());
                    }
                } else {
                    _networkErrors.postValue(DEFAULT_NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<ResponseRecipesRequest> call, Throwable t) {
                _networkErrors.postValue(t.getMessage());
            }
        });

    }

    public LiveData<String> getNetworkErrors() {
        return _networkErrors;
    }
}
