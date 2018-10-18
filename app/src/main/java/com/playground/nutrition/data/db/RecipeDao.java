package com.playground.nutrition.data.db;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.playground.nutrition.data.RecipeContract;
import com.playground.nutrition.entities.Recipe;

import java.util.List;

/**
 * Created by emil.ivanov on 10/17/18.
 */
@Dao
public interface RecipeDao {

    String QUERY_ALL = "SELECT * FROM " + RecipeContract.TABLE;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Recipe recipe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Recipe> recipeList);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Recipe recipe);

    @Query(QUERY_ALL)
    DataSource.Factory<Integer, Recipe> searchQuery();


}
