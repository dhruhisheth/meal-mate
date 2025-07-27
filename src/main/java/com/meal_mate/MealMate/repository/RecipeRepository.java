package com.meal_mate.MealMate.repository;

import com.meal_mate.MealMate.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//DB for CRUD ops
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    // Method used by: getRecipesByTag(), getVeganRecipes(), getVegetarianRecipes()
    List<Recipe> findByTagsContaining(String tag);

    // Method used by: getQuickRecipes()
    List<Recipe> findByCookingTimeLessThanEqual(int cookingTime);
}