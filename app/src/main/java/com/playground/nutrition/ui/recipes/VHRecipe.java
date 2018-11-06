package com.playground.nutrition.ui.recipes;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.playground.nutrition.R;
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

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.image_no_recipe_available);

        Glide.with(itemView.getContext())
                .load(recipe.getImageUrl())
                .apply(requestOptions)
                .into(binding.ivRecipeImage);
    }
}
