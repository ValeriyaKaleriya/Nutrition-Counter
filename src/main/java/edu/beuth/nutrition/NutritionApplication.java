package edu.beuth.nutrition;

import edu.beuth.nutrition.model.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NutritionApplication {

    public static void main(String[] args) {



        SpringApplication.run(NutritionApplication.class, args);

        Category cat = new Category();
        cat.setName("cateogry");
        System.out.println(cat.getName());
    }

}

