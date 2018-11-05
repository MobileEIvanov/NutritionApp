package com.playground.nutrition.data;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public interface RecipeContract {

    String _ID = "id";
    String TABLE = "recipes";
    String SINGLE_ITEM = "recipe";

    String COL_TITLE = "title";
    String COL_PREVIEW_URL = "href";
    String COL_IMAGE_URL = "thumbnail";


    /* Only remote related */
    String PARAM_COUNT = "count";
    String PARAM_PAGE = "page";
    String PARAM_RECIPES_COLLECTION = "results";
    String COL_INGREDIENTS = "ingredients";
}
