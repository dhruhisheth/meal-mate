package com.meal_mate.MealMate.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "MealMate")
public class Recipe {

    private String name;
    private String description;
    private int cookingTime;
    private String difficulty;
    private String[] ingredients;
    private String[] instructions;
    private String cuisine;
    private String[] tags;
    private double rating;
    private int servings;
    private String[] nutritionInfo;

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String[] getNutritionInfo() {
        return nutritionInfo;
    }

    public void setNutritionInfo(String[] nutritionInfo) {
        this.nutritionInfo = nutritionInfo;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cookingTime=" + cookingTime +
                ", difficulty='" + difficulty + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", instructions=" + Arrays.toString(instructions) +
                ", cuisine='" + cuisine + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", rating=" + rating +
                ", servings=" + servings +
                ", nutritionInfo=" + Arrays.toString(nutritionInfo) +
                '}';
    }
}