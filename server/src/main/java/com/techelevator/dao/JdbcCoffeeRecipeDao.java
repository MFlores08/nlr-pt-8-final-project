package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CoffeeRecipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCoffeeRecipeDao implements CoffeeRecipeDao{

    private final JdbcTemplate template;
    public JdbcCoffeeRecipeDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }
    private List<CoffeeRecipe> coffeeRecipes = new ArrayList<>();

    private final RowMapper<CoffeeRecipe> mapper = new RowMapper<CoffeeRecipe>(){
        @Override
        public CoffeeRecipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            int recipeId = rs.getInt("recipe_id");
            String recipeName = rs.getString("recipe_name");
            int collectionId = rs.getInt("collection_id");
            String ingredients = rs.getString("ingredients");
            String directions = rs.getString("directions");
            return new CoffeeRecipe(recipeId, recipeName, collectionId, ingredients, directions);
        }
    };

    @Override
    public List<CoffeeRecipe> getAllCoffeeRecipes() {
        return template.query("SELECT * FROM coffee_recipes", mapper);
    }

    @Override
    public CoffeeRecipe getCoffeeRecipeById(int recipeId) {
        String sql = "SELECT * FROM coffee_recipes WHERE recipe_id = ?";
        return template.queryForObject(sql,mapper,recipeId);
    }

    @Override
    public CoffeeRecipe getCoffeeRecipeByCollectionId(int collectionId) {
        String sql = "SELECT * FROM coffee_recipes WHERE collection_id = ?";
        return template.queryForObject(sql,mapper,collectionId);
    }

    @Override
    public CoffeeRecipe getCoffeeRecipeByRecipeName(String recipeName) {
        String sql = "SELECT * FROM coffee_recipes WHERE recipe_name = ?";
        return template.queryForObject(sql,mapper,recipeName);
    }

    @Override
    public CoffeeRecipe createCoffeeRecipe(CoffeeRecipe newCoffeeRecipe) {
        String sql = "INSERT INTO coffee_recipes (recipe_name, collection_id, ingredients, directions) VALUES (?, ?, ?, ?)";
        int id = template.update(sql,
                newCoffeeRecipe.getName(),
                newCoffeeRecipe.getCollectionId(),
                newCoffeeRecipe.getIngredients(),
                newCoffeeRecipe.getDirections());
        return getCoffeeRecipeByRecipeName(newCoffeeRecipe.getName());
    }

    @Override
    public CoffeeRecipe updateCoffeeRecipe(CoffeeRecipe coffeeRecipe){
        String sql = "UPDATE coffee_recipes SET recipe_name = ?, collection_id = ?, ingredients = ?, directions = ? WHERE recipe_id = ?";
        template.update(sql, coffeeRecipe.getName(),
                coffeeRecipe.getCollectionId(),
                coffeeRecipe.getIngredients(),
                coffeeRecipe.getDirections(),
                coffeeRecipe.getId());
        return getCoffeeRecipeById(coffeeRecipe.getId());
    }

    @Override
    public int deleteCoffeeRecipeById(int id) {
        String sql = "DELETE FROM coffee_recipes WHERE recipe_id = ?";
        return template.update(sql, id);
    }
}
