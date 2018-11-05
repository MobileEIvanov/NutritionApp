package com.playground.nutrition.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

import com.playground.nutrition.entities.Recipe;

/**
 * Created by emil.ivanov on 10/17/18.
 */

@Database(entities = {Recipe.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class RecipesDatabase extends RoomDatabase {


    private static final String LOG_TAG = RecipesDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "nutrition_app";
    private static RecipesDatabase sInstance;

    public static RecipesDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        RecipesDatabase.class, DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Returned database instance");
        return sInstance;
    }

    public abstract RecipeDao foodDao();


}
