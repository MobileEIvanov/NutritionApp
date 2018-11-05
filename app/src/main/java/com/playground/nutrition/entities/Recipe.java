package com.playground.nutrition.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playground.nutrition.data.RecipeContract;

/**
 * Created by emil.ivanov on 10/17/18.
 */
@Entity(tableName = RecipeContract.TABLE)
public class Recipe {

    public Recipe() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = RecipeContract._ID)
    int id;

    @SerializedName(RecipeContract.COL_TITLE)
    @ColumnInfo(name = RecipeContract.COL_TITLE)
    String title;

    @SerializedName(RecipeContract.COL_IMAGE_URL)
    @ColumnInfo(name = RecipeContract.COL_IMAGE_URL)
    String imageUrl;


    @SerializedName(RecipeContract.COL_PREVIEW_URL)
    @ColumnInfo(name = RecipeContract.COL_PREVIEW_URL)
    String previewUrl;

    @SerializedName(RecipeContract.COL_INGREDIENTS)
    String ingredients;


    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getIngredients() {
        return ingredients;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                '}';
    }
}

