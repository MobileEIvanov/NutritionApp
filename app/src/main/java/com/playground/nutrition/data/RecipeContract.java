package com.playground.nutrition.data;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public interface RecipeContract {
    String TABLE = "recipes";
    String SINGLE_ITEM = "recipe";
    String _ID = "id";
    String COL_TITLE = "title";
    String COL_SERVER_ID = "recipe_id";
    String COL_SOURCE_URL = "source_url";
    String COL_PREVIEW_URL = "f2f_url";
    String COL_IMAGE_URL = "image_url";
    String COL_SOCIAL_RANK = "social_rank";

    /* Only remote related */
    String PARAM_COUNT = "count";
    String PARAM_PAGE = "page";
    String PARAM_RECIPES_COLLECTION = "recipes";
    String COL_INGREDIENTS = "ingredients";
}
