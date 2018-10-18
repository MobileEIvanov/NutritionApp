package com.playground.nutrition.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

import com.playground.nutrition.data.IngredientsContract;
import com.playground.nutrition.data.RecipeContract;

/**
 * Created by emil.ivanov on 10/18/18.
 */
class Ingredient {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = IngredientsContract._ID)
    int id;
    @ColumnInfo(name = IngredientsContract.COL_DESCRIPTION)
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
