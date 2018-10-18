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
    private String query;
    private int _lastRequestedPage = 1;
    private boolean _isRequestInProgress = false;

    public DataBoudnaryCallback(String searchQuery, RemoteDataSource service, LocalDataSource database) {
        this.service = service;
        this.database = database;
        this.query = searchQuery;
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
        if (_isRequestInProgress) {
            return;
        }
        _isRequestInProgress = true;

        service.searchQuery(query, _lastRequestedPage, new Callback<ResponseRecipesRequest>() {
            @Override
            public void onResponse(Call<ResponseRecipesRequest> call, Response<ResponseRecipesRequest> response) {
                if (response.isSuccessful()) {
                    _lastRequestedPage++;
                    ResponseRecipesRequest responseRecipesRequest = response.body();
                    if (responseRecipesRequest != null) {
                        database.insert(responseRecipesRequest.getListData());
                    }
                    _isRequestInProgress=false;
                } else {
                    _isRequestInProgress=false;
                    _networkErrors.postValue(DEFAULT_NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<ResponseRecipesRequest> call, Throwable t) {
                _networkErrors.postValue(t.getMessage());
                _isRequestInProgress=false;
            }
        });

    }

    public LiveData<String> getNetworkErrors() {
        return _networkErrors;
    }
}
