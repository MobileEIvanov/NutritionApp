package com.playground.nutrition.data.entities;

import com.google.gson.annotations.SerializedName;
import com.playground.nutrition.data.RecipeContract;
import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/18/18.
 */
public class ResponseRecipeDetails {
    @SerializedName(RecipeContract.SINGLE_ITEM)
    Recipe recipe;
}
