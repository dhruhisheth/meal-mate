package com.meal_mate.MealMate.repository;

import com.meal_mate.MealMate.model.Recipe;

import java.util.List;

public interface SearchRepository {

    List<Recipe> findByText (String text);
}
