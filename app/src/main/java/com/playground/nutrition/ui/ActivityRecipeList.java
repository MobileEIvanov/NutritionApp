package com.playground.nutrition.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playground.nutrition.R;
import com.playground.nutrition.databinding.ActivityRecipeListBinding;

public class ActivityRecipeList extends AppCompatActivity {
    ActivityRecipeListBinding binding;
    public static final String LATEST_QUERY = "last_query";
    RecipesViewModel mViewModel;
    AdapterRecipes mAdapter = new AdapterRecipes(AdapterRecipes.COMPARE_RECIPES);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_list);

        RecipesViewModelFactory factory = new RecipesViewModelFactory(this.getApplicationContext());
        mViewModel = ViewModelProviders.of(this, factory).get(RecipesViewModel.class);
        String query = "";
        if (savedInstanceState != null) {
            query = savedInstanceState.getString(LATEST_QUERY);
        }

        initAdapter();
        mViewModel.queryAll(query);
    }

    private void initAdapter() {
        mViewModel.foodsData.observe(this, recipes -> mAdapter.submitList(recipes));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(LATEST_QUERY, mViewModel.getLatestQuery());
        super.onSaveInstanceState(outState);
    }
}
