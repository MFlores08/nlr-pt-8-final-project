package com.techelevator.dao;

import com.techelevator.model.NutritionInfo;

import java.util.List;

public interface NutritionInfoDao {
    NutritionInfo getNutritionInfoByRecipeId(int recipeId);
    NutritionInfo createNutritionInfo(NutritionInfo nutritionInfo);
    NutritionInfo updateNutritionInfo(NutritionInfo nutritionInfo);
    int deleteNutritionInfoById(int id);
}
