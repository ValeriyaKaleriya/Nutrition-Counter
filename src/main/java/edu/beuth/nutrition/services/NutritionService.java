package edu.beuth.nutrition.services;

import edu.beuth.nutrition.models.Ingredient;
import edu.beuth.nutrition.models.RecipeIngredient;
import edu.beuth.nutrition.repositories.IngredientRepository;
import edu.beuth.nutrition.repositories.RecipeIngredientRepository;

import java.util.List;

public class NutritionService {

    private IngredientRepository ingredientRepository;
    private RecipeIngredientRepository recipeIngredientRepository;

    public NutritionService(IngredientRepository ingredientRepository,
                            RecipeIngredientRepository recipeIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    public List<RecipeIngredient> findAllRecipes() {
        return recipeIngredientRepository.findAll();
    }
}
