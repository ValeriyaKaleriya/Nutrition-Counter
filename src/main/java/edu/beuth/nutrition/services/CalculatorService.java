package edu.beuth.nutrition.services;

import edu.beuth.nutrition.models.CalulatorDTO;
import edu.beuth.nutrition.models.Detail;
import edu.beuth.nutrition.models.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CalculatorService {

    @PostMapping("/api/calculate")
    @ResponseBody
    public List<Ingredient> calculateCalories(@RequestBody CalulatorDTO calulatorDTO) {
        int[] idx = { 0 };
        List<Ingredient> updatedIngredients = calulatorDTO.ingredients
                .stream()
                .map(d -> updateIngredient(d, calulatorDTO.quantity.get(idx[0]++)))
                .collect(Collectors.toList());

        return updatedIngredients;
    }

    private Ingredient updateIngredient(Ingredient ingredient, double quantity) {
        Ingredient ing = new Ingredient();
        Detail det = new Detail();
        det.setKcal(scaleMeasurement(ingredient.getDetail().getKcal(), quantity));
        det.setFat(scaleMeasurement(ingredient.getDetail().getFat(), quantity));
        det.setProtein(scaleMeasurement(ingredient.getDetail().getProtein(), quantity));
        det.setCarb(scaleMeasurement(ingredient.getDetail().getCarb(), quantity));
        ing.setDetail(det);
        ing.setName(ingredient.getName());
        return ing;
    }

    private double scaleMeasurement(double measure, double quantity) {
        return measure * quantity / 100;
    }
}
