package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.NutritionInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcNutritionInfoDao implements NutritionInfoDao{
    private final JdbcTemplate template;
    public JdbcNutritionInfoDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    private List<NutritionInfo> nutritionInfos = new ArrayList<>();

    private final RowMapper<NutritionInfo> mapper = new RowMapper<NutritionInfo>(){
        @Override
        public NutritionInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            int nutritionId = rs.getInt("nutrition_id");
            int recipeId = rs.getInt("recipe_id");
            int sugarContent = rs.getInt("sugar_content");
            int sodiumContent = rs.getInt("sodium_content");
            int caffeineContent = rs.getInt("caffeine_content");
            return new NutritionInfo(nutritionId, recipeId, sugarContent, sodiumContent, caffeineContent);
        }
    };

    @Override
    public NutritionInfo getNutritionInfoByRecipeId(int recipeId) {
        String sql = "SELECT * FROM nutrition_info WHERE recipe_id = ?";
        return template.queryForObject(sql,mapper,recipeId);
    }

    @Override
    public NutritionInfo createNutritionInfo(NutritionInfo nutritionInfo) {
        String sql = "INSERT INTO nutrition_info (recipe_id, sugar_content, sodium_content, caffeine_content) VALUES (?, ?, ?, ?)";
        template.update(sql,
                nutritionInfo.getRecipeId(),
                nutritionInfo.getSugarContent(),
                nutritionInfo.getSodiumContent(),
                nutritionInfo.getCaffeineContent());
        return getNutritionInfoByRecipeId(nutritionInfo.getRecipeId());
    }


    @Override
    public NutritionInfo updateNutritionInfo(NutritionInfo nutritionInfo) {
        String sql = "UPDATE nutrition_info SET recipe_id = ?, sugar_content = ?, sodium_content = ?, caffeine_content = ? WHERE nutrition_id = ?";
        template.update(sql,
                nutritionInfo.getRecipeId(),
                nutritionInfo.getSugarContent(),
                nutritionInfo.getSodiumContent(),
                nutritionInfo.getCaffeineContent(),
                nutritionInfo.getNutritionId());
        return getNutritionInfoByRecipeId(nutritionInfo.getRecipeId());
    }

    @Override
    public int deleteNutritionInfoById(int id) {
        String sql = "DELETE FROM nutrition_info WHERE nutrition_id = ?";
        return template.update(sql, id);
    }
}
