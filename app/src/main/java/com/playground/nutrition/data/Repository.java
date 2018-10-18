package com.playground.nutrition.data;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.content.Context;

import com.playground.nutrition.Injector;
import com.playground.nutrition.data.db.LocalDataSource;
import com.playground.nutrition.data.entities.ResponseRecipesWrapper;
import com.playground.nutrition.data.remote.RemoteDataSource;
import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class Repository {

    private static final int DB_PAGE_SIZE = 20;
    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;

    public Repository(Context context) {
        localDataSource = Injector.provideLocalDatasource(context);
        remoteDataSource = Injector.provideRemoteDatasource();
    }


    public ResponseRecipesWrapper queryAll() {

        DataSource.Factory<Integer, Recipe> factory = localDataSource.queryAll();

        DataBoudnaryCallback boudnaryCallback = new DataBoudnaryCallback(remoteDataSource, localDataSource);

        LiveData<String> networkErrors = boudnaryCallback.getNetworkErrors();

        LiveData<PagedList<Recipe>> pagedList = new LivePagedListBuilder(factory, DB_PAGE_SIZE)
                .setBoundaryCallback(boudnaryCallback)
                .build();

        return new ResponseRecipesWrapper(pagedList, networkErrors);
    }

}
