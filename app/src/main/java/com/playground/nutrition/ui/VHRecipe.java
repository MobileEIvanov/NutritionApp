package com.playground.nutrition.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.playground.nutrition.databinding.ItemRecipeBinding;
import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class VHRecipe extends RecyclerView.ViewHolder {

    ItemRecipeBinding binding;

    public VHRecipe(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bindData(Recipe recipe) {
        binding.tvRecipeTitle.setText(recipe.getTitle());
    }
}
