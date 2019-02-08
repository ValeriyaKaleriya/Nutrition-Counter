package edu.beuth.nutrition.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "nutrition", name = "recipe_ingredients")
public class RecipeIngredient {

    @Column(name = "recipe_id")
    private Recipe recipe;

    @Column(name = "ingredient_id")
    private Ingredient ingredient;

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
