package com.playground.nutrition.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.playground.nutrition.data.RecipeContract;

import java.util.List;

/**
 * Created by emil.ivanov on 10/17/18.
 */
@Entity
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = RecipeContract._ID)
    int id;

    @SerializedName(RecipeContract.COL_TITLE)
    @ColumnInfo(name = RecipeContract.COL_TITLE)
    String title;

    @SerializedName(RecipeContract.COL_IMAGE_URL)
    @ColumnInfo(name = RecipeContract.COL_IMAGE_URL)
    String imageUrl;

    @SerializedName(RecipeContract.COL_SERVER_ID)
    @ColumnInfo(name = RecipeContract.COL_SERVER_ID)
    String serverId;

    @SerializedName(RecipeContract.COL_SOCIAL_RANK)
    @ColumnInfo(name = RecipeContract.COL_SOCIAL_RANK)
    double socialRank;

    @SerializedName(RecipeContract.COL_PREVIEW_URL)
    @ColumnInfo(name = RecipeContract.COL_PREVIEW_URL)
    String previewUrl;

    @SerializedName(RecipeContract.COL_INGREDIENTS)
    @ColumnInfo(name = RecipeContract.COL_INGREDIENTS)
    List<String> ingredients;

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getServerId() {
        return serverId;
    }

    public double getSocialRank() {
        return socialRank;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", serverId='" + serverId + '\'' +
                ", socialRank=" + socialRank +
                ", previewUrl='" + previewUrl + '\'' +
                '}';
    }
}

