package com.playground.nutrition.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playground.nutrition.data.RecipeContract;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.meta.Exclusive;

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

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public void setSocialRank(double socialRank) {
        this.socialRank = socialRank;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setUsedIngredients(Ingredients usedIngredients) {
        this.usedIngredients = usedIngredients;
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

    @SerializedName(RecipeContract.COL_SERVER_ID)
    @ColumnInfo(name = RecipeContract.COL_SERVER_ID)
    String serverId;

    @SerializedName(RecipeContract.COL_SOCIAL_RANK)
    @ColumnInfo(name = RecipeContract.COL_SOCIAL_RANK)
    double socialRank;

    @SerializedName(RecipeContract.COL_PREVIEW_URL)
    @ColumnInfo(name = RecipeContract.COL_PREVIEW_URL)
    String previewUrl;

    @Ignore
    @SerializedName(RecipeContract.COL_INGREDIENTS)
    List<String> ingredients = new ArrayList<>();

    @Expose(serialize = false, deserialize = false)
    @ColumnInfo(name = RecipeContract.COL_INGREDIENTS)
    Ingredients usedIngredients;

    public Ingredients getUsedIngredients() {
        if (ingredients != null) {
            usedIngredients = new Ingredients(ingredients);
        }
        return usedIngredients;
    }

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

