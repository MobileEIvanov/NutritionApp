package com.playground.nutrition.data.db;

import android.arch.persistence.room.TypeConverter;

import com.playground.nutrition.entities.Ingredients;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emil.ivanov on 10/18/18.
 */
public class IngredientsConvertor {

//    @TypeConverter
//    public Ingredients storedStringToIngredientList(String value) {
//        List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
//        return new Ingredients(langs);
//    }
//
//    @TypeConverter
//    public String ingredientToStoredString(Ingredients ingredients) {
//        String value = "";
//
//        for (String ingredient : ingredients.getList())
//            value += ingredient + ",";
//
//        return value;
//    }
}
