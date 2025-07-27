package com.meal_mate.MealMate.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.meal_mate.MealMate.model.Recipe;
import com.meal_mate.MealMate.repository.RecipeRepository;
import com.meal_mate.MealMate.repository.SearchRepository;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

    @Autowired
    RecipeRepository repo;

    @Autowired
    SearchRepository srepo;

    // 1. Root redirect to Swagger
    @RequestMapping("/")
    @Hidden
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    // 2. Get all recipes
    @GetMapping("/allRecipes")
    @CrossOrigin
    public List<Recipe> getAllRecipes() {
        return repo.findAll();
    }

    // 3. Add new recipe
    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return repo.save(recipe);
    }

    // 4. Search recipes
    @GetMapping("/recipes/{text}")
    @Operation(summary = "Search recipes", description = "Search by ingredients, name, or cuisine")
    public List<Recipe> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    // 5. Filter by dietary preference
    @GetMapping("/recipes/tag/{tag}")
    @Operation(summary = "Filter by dietary tag", description = "Get recipes by tag: vegan, vegetarian, gluten-free, healthy, low-carb")
    public List<Recipe> getRecipesByTag(@PathVariable String tag) {
        return repo.findByTagsContaining(tag);
    }

    // 6. Quick recipes filter
    @GetMapping("/recipes/time/{maxTime}")
    @Operation(summary = "Get quick recipes", description = "Find recipes under specified cooking time in minutes")
    public List<Recipe> getQuickRecipes(@PathVariable int maxTime) {
        return repo.findByCookingTimeLessThanEqual(maxTime);
    }

    // 7. Vegan recipes
    @GetMapping("/recipes/vegan")
    @Operation(summary = "Get vegan recipes", description = "Get all plant-based vegan recipes")
    public List<Recipe> getVeganRecipes() {
        return repo.findByTagsContaining("vegan");
    }

    // 8. Vegetarian recipes
    @GetMapping("/recipes/vegetarian")
    @Operation(summary = "Get vegetarian recipes", description = "Get all vegetarian recipes")
    public List<Recipe> getVegetarianRecipes() {
        return repo.findByTagsContaining("vegetarian");
    }
}