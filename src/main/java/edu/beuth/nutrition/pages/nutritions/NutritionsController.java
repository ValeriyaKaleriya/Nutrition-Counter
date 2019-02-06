package edu.beuth.nutrition.pages.nutritions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NutritionsController {

    @GetMapping("/nutritions")
    String index() {
        return "nutritions";
    }
}
