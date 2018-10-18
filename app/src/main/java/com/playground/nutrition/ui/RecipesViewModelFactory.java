package com.playground.nutrition.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.playground.nutrition.Injector;
import com.playground.nutrition.data.Repository;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class RecipesViewModelFactory implements ViewModelProvider.Factory {
    Repository repository;

    public RecipesViewModelFactory(Context context) {
        repository = Injector.provideRepository(context);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RecipesViewModel(repository);
    }
}
