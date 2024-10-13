package com.techelevator.controller;


import com.techelevator.dao.NutritionInfoDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.NutritionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/nutrition_info")
public class NutritionInfoController {
    private NutritionInfoDao nutritionInfoDao;
    public NutritionInfoController(NutritionInfoDao nutritionInfoDao) {
        this.nutritionInfoDao = nutritionInfoDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{recipeId}")
    public NutritionInfo getNutritionInfoById(@PathVariable int recipeId){
        NutritionInfo nutritionInfo = nutritionInfoDao.getNutritionInfoByRecipeId(recipeId);
        if (nutritionInfo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nutrition Info not found");
        } else {
            return nutritionInfo;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public NutritionInfo createNutritionInfo(@RequestBody NutritionInfo nutritionInfo){
        return nutritionInfoDao.createNutritionInfo(nutritionInfo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public NutritionInfo updateNutritionInfo(@RequestBody NutritionInfo nutritionInfo, @PathVariable int id){
        nutritionInfo.setNutritionId(id);
        try {
            NutritionInfo updatedNutritionInfo = nutritionInfoDao.updateNutritionInfo(nutritionInfo);
            return updatedNutritionInfo;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nutrition Info Not Found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteNutritionInfoById(@PathVariable int id) {
        int rowsAffected = nutritionInfoDao.deleteNutritionInfoById(id);
        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nutrition Info not found", null);
        }
    }

}
