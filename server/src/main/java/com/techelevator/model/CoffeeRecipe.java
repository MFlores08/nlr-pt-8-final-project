package com.techelevator.model;

import com.techelevator.dao.CollectionDao;
import jakarta.validation.constraints.NotBlank;

public class CoffeeRecipe {

    private int recipeId;

    private String recipeName;

    private int collectionId;
    private String ingredients;
    private String directions;


    public CoffeeRecipe(int recipeId, String recipeName, int collectionId, String ingredients, String directons) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.collectionId = collectionId;
        this.ingredients = ingredients;
        this.directions = directons;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "CoffeeRecipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", collectionId=" + collectionId +
                ", ingredients='" + ingredients + '\'' +
                ", directons='" + directions + '\'' +
                '}';
    }
}
