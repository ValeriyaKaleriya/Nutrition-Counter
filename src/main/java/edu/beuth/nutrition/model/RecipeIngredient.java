package edu.beuth.nutrition.model;


import javax.persistence.*;

@Entity
@Table(schema = "nutrition", name = "recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "recipe_id")
    @ManyToOne
    private Recipe recipe;

    @JoinColumn(name = "ingredient_id")
    @ManyToOne
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
