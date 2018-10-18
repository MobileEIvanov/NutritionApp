package com.playground.nutrition.ui;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playground.nutrition.R;
import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class AdapterRecipes extends PagedListAdapter<Recipe, VHRecipe> {
    protected AdapterRecipes(@NonNull DiffUtil.ItemCallback<Recipe> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public VHRecipe onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recipe, viewGroup, false);
        return new VHRecipe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHRecipe vhRecipe, int i) {
        Recipe recipe = getItem(i);
        if (recipe != null) {
            vhRecipe.bindData(recipe);
        }
    }


    public static DiffUtil.ItemCallback<Recipe> COMPARE_RECIPES = new DiffUtil.ItemCallback<Recipe>() {
        @Override
        public boolean areItemsTheSame(@NonNull Recipe recipe, @NonNull Recipe t1) {
            return recipe.getId() == t1.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Recipe recipe, @NonNull Recipe t1) {
            return recipe.equals(t1);
        }

        @Nullable
        @Override
        public Object getChangePayload(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
            return newItem;
        }
    };
}
