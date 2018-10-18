package com.playground.nutrition.data.db;

import android.arch.paging.DataSource;
import android.content.Context;

import com.playground.nutrition.AppExecutors;
import com.playground.nutrition.Injector;
import com.playground.nutrition.entities.Recipe;

import java.util.List;


/**
 * Created by emil.ivanov on 10/17/18.
 */
public class LocalDataSource {


    // Depends on Database
    RecipesDatabase database;

    public LocalDataSource(Context context) {
        database = Injector.providesDatabase(context);
    }

    public void insert(final Recipe recipe) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                database.foodDao().insert(recipe);
            }
        });
    }

    public void insert(final List<Recipe> recipeList) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                database.foodDao().insert(recipeList);
            }
        });
    }

    public void update(final Recipe recipe) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                database.foodDao().insert(recipe);
            }
        });
    }

    public DataSource.Factory<Integer, Recipe> queryAll() {
        return database.foodDao().queryForAll();
    }
}
