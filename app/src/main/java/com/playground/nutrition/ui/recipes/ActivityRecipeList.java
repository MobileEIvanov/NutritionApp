package com.playground.nutrition.ui.recipes;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.playground.nutrition.R;
import com.playground.nutrition.databinding.ActivityRecipeListBinding;

public class ActivityRecipeList extends AppCompatActivity {
    ActivityRecipeListBinding binding;
    public static final String LATEST_QUERY = "last_query";
    public static final String DEFAULT_QUERY = "";
    RecipesViewModel mViewModel;
    AdapterRecipes mAdapter = new AdapterRecipes(AdapterRecipes.COMPARE_RECIPES);
    String mSearchQuery = DEFAULT_QUERY;

    View.OnClickListener mOnSearchListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mViewModel.queryAll(mSearchQuery);
            binding.searchViewContent.etSearchQuery.setText("");
            binding.searchViewContent.etSearchQuery.clearFocus();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_list);

        RecipesViewModelFactory factory = new RecipesViewModelFactory(this.getApplicationContext());
        mViewModel = ViewModelProviders.of(this, factory).get(RecipesViewModel.class);

        if (savedInstanceState != null) {
            mSearchQuery = savedInstanceState.getString(LATEST_QUERY);
        }

        initAdapter();
        initSearchView();
        initErrorHandler();

        if (!TextUtils.isEmpty(mSearchQuery)) {
            mViewModel.queryAll(mSearchQuery);
        }

    }

    private void initAdapter() {

        binding.rvRecipes.setAdapter(mAdapter);
        mViewModel.foodsData.observe(this, recipes -> {
            binding.rvRecipes.setVisibility(recipes.isEmpty() ? View.INVISIBLE : View.VISIBLE);
            binding.emptyView.setVisibility(recipes.isEmpty() ? View.VISIBLE : View.INVISIBLE);
            mAdapter.submitList(recipes);
        });
    }

    private void initSearchView() {
        updateSearchViewState(false);
        binding.searchViewContent.etSearchQuery.addTextChangedListener(mSearchWatcher);
        binding.searchViewContent.btnSearch.setOnClickListener(mOnSearchListener);
    }

    private void initErrorHandler() {
        mViewModel.networkErrors.observe(this, s -> Toast.makeText(ActivityRecipeList.this, s, Toast.LENGTH_SHORT).show());
    }

    TextWatcher mSearchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mSearchQuery = s.toString();
            boolean isSearchAllowed = s.length() > 0;
            updateSearchViewState(isSearchAllowed);
        }
    };

    private void updateSearchViewState(boolean isAllowedToSearch) {
        binding.searchViewContent.btnSearch.setEnabled(isAllowedToSearch);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(LATEST_QUERY, mViewModel.getLatestQuery());
        super.onSaveInstanceState(outState);
    }
}
