package com.playground.nutrition.entities;

import java.util.List;

/**
 * Created by emil.ivanov on 10/18/18.
 */
public class Ingredients {
    List<String> ingredients;

    public Ingredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getList() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
