package com.techelevator.model;

import jakarta.validation.constraints.NotBlank;

public class NutritionInfo {
    private int nutritionId;
    @NotBlank(message = "The recipe_id field must not be blank.")
    private int recipeId;
    private int sugarContent;
    private int sodiumContent;
    private int caffeineContent;

    public NutritionInfo(int nutritionId, int recipeId, int sugarContent, int sodiumContent, int caffeineContent) {
        this.nutritionId = nutritionId;
        this.recipeId = recipeId;
        this.sugarContent = sugarContent;
        this.sodiumContent = sodiumContent;
        this.caffeineContent = caffeineContent;
    }

    public int getNutritionId() {
        return nutritionId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public int getSodiumContent() {
        return sodiumContent;
    }

    public int getCaffeineContent() {
        return caffeineContent;
    }

    public void setNutritionId(int nutritionId) {
        this.nutritionId = nutritionId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }

    public void setSodiumContent(int sodiumContent) {
        this.sodiumContent = sodiumContent;
    }

    public void setCaffeineContent(int caffeineContent) {
        this.caffeineContent = caffeineContent;
    }

    @Override
    public String toString() {
        return "NutritionInfo{" +
                "nutritionId=" + nutritionId +
                ", recipeId=" + recipeId +
                ", sugarContent=" + sugarContent +
                ", sodiumContent=" + sodiumContent +
                ", caffeineContent=" + caffeineContent +
                '}';
    }
}
