package com.techelevator.dao;

import com.techelevator.model.CoffeeRecipe;

import java.util.List;

public interface CoffeeRecipeDao {
    List<CoffeeRecipe> getAllCoffeeRecipes();
    CoffeeRecipe getCoffeeRecipeById(int recipeId);
    CoffeeRecipe getCoffeeRecipeByCollectionId(int collectionId);
    CoffeeRecipe getCoffeeRecipeByRecipeName(String recipeName);
    CoffeeRecipe createCoffeeRecipe(CoffeeRecipe newCoffeeRecipe);
    CoffeeRecipe updateCoffeeRecipe(CoffeeRecipe coffeeRecipe);
    int deleteCoffeeRecipeById(int id);
}
