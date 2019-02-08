package edu.beuth.nutrition.services;

import edu.beuth.nutrition.models.Detail;
import edu.beuth.nutrition.models.Ingredient;

import java.util.List;

public class Calculator {

    public List<Ingredient> calculateCalories(List<Ingredient> ingredients, double quantity) {
        ingredients
                .forEach(d -> d.setDetail(new Detail(scaleMeasurement(d.getDetail().getKcal(), quantity),
                        scaleMeasurement(d.getDetail().getFat(), quantity),
                        scaleMeasurement(d.getDetail().getProtein(), quantity),
                        scaleMeasurement(d.getDetail().getCarb(), quantity))));
        return ingredients;
    }

    private double scaleMeasurement(double measure, double quantity) {
        return measure * quantity / 100;
    }
}
