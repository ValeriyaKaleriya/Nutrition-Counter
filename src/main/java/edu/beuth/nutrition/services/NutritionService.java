package edu.beuth.nutrition.services;

import edu.beuth.nutrition.models.Ingredient;
import edu.beuth.nutrition.models.RecipeIngredient;
import edu.beuth.nutrition.repositories.IngredientRepository;
import edu.beuth.nutrition.repositories.RecipeIngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NutritionService {

    private IngredientRepository ingredientRepository;
    private RecipeIngredientRepository recipeIngredientRepository;

    public NutritionService(IngredientRepository ingredientRepository,
                            RecipeIngredientRepository recipeIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }


    @GetMapping("/api/ingredients")
    @ResponseBody
    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }


    @GetMapping("/api/recipes")
    @ResponseBody
    public List<RecipeIngredient> findAllRecipes() {
        return recipeIngredientRepository.findAll();
    }
}
