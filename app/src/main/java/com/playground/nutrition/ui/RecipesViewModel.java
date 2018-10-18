package com.playground.nutrition.ui;


import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.playground.nutrition.data.Repository;
import com.playground.nutrition.data.entities.ResponseRecipesWrapper;
import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */
class RecipesViewModel extends ViewModel {
    private Repository repository;

    private MutableLiveData<String> _requestQuery = new MutableLiveData<>();
    private LiveData<ResponseRecipesWrapper> _repoResponse = Transformations.map(_requestQuery, new Function<String, ResponseRecipesWrapper>() {
        @Override
        public ResponseRecipesWrapper apply(String input) {
            return repository.queryAll();
        }
    });

    LiveData<String> networkErrors = Transformations.switchMap(_repoResponse, input -> input.getNetworkError());
    LiveData<PagedList<Recipe>> foodsData = Transformations.switchMap(_repoResponse, input -> input.getData());

    public RecipesViewModel(Repository repository) {
        this.repository = repository;
    }

    void queryAll(String query) {
        _requestQuery.postValue(query);
    }

    public String getLatestQuery() {
        return _requestQuery.getValue();
    }
}
