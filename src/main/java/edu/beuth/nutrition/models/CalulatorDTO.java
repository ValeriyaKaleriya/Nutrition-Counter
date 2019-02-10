package edu.beuth.nutrition.models;

import java.util.List;

public class CalulatorDTO {
    private final List<Ingredient> ingredients;
    private final List<Double> quantity;

    public CalulatorDTO(List<Ingredient> ingredients, List<Double> quantity) {
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public List<Double> getQuantity() {
        return quantity;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
