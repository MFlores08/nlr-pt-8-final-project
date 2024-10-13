package com.techelevator.controller;


import com.techelevator.dao.CoffeeRecipeDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.CoffeeRecipe;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/coffee_recipes")
public class CoffeeRecipeController {
    private CoffeeRecipeDao coffeeRecipeDao;
    public CoffeeRecipeController(CoffeeRecipeDao coffeeRecipeDao){
        this.coffeeRecipeDao = coffeeRecipeDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CoffeeRecipe> getAllCoffeeRecipes(){
        List<CoffeeRecipe> coffeeRecipes = coffeeRecipeDao.getAllCoffeeRecipes();
        if (coffeeRecipes == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found");
        } else {
            return coffeeRecipes;
        }
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{recipeId}")
    public CoffeeRecipe getCoffeeRecipeById(@PathVariable int recipeId){
        CoffeeRecipe coffeeRecipe = coffeeRecipeDao.getCoffeeRecipeById(recipeId);
        if (coffeeRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found");
        } else {
            return coffeeRecipe;
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("collection_id /{collectionId}")
    public CoffeeRecipe getCoffeeRecipeByCollectionId(@PathVariable int collectionId){
        CoffeeRecipe coffeeRecipe = coffeeRecipeDao.getCoffeeRecipeByCollectionId(collectionId);
        if (coffeeRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found");
        } else {
            return coffeeRecipe;
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{recipe_name}")
    public CoffeeRecipe getCoffeeRecipeByRecipeName(@PathVariable String recipeName){
        CoffeeRecipe coffeeRecipe = coffeeRecipeDao.getCoffeeRecipeByRecipeName(recipeName);
        if (coffeeRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found");
        } else {
            return coffeeRecipe;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public CoffeeRecipe createCoffeeRecipe(@RequestBody CoffeeRecipe coffeeRecipe){
        return coffeeRecipeDao.createCoffeeRecipe(coffeeRecipe);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public CoffeeRecipe updateCoffeeRecipe(@RequestBody CoffeeRecipe coffeeRecipe, @PathVariable int id){
        coffeeRecipe.setRecipeId(id);
        try {
            CoffeeRecipe updatedCoffeeRecipe = coffeeRecipeDao.updateCoffeeRecipe(coffeeRecipe);
            return updatedCoffeeRecipe;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCoffeeRecipeById(@PathVariable int id) {
        int rowsAffected = coffeeRecipeDao.deleteCoffeeRecipeById(id);
        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee recipe not found", null);
        }
    }
}
