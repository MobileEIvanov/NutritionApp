package com.playground.nutrition.data.entities;

import com.google.gson.annotations.SerializedName;
import com.playground.nutrition.data.RecipeContract;
import com.playground.nutrition.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class ResponseRecipesRequest {
//    @SerializedName(RecipeContract.PARAM_COUNT)
//    int count;
//    @SerializedName(RecipeContract.PARAM_PAGE)
//    int page;
    @SerializedName(RecipeContract.PARAM_RECIPES_COLLECTION)
    List<Recipe> recipeList;

    public List<Recipe> getListData() {
        if (recipeList == null) {
            return new ArrayList<>();
        } else {
            return this.recipeList;
        }
    }
}
