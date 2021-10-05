package castanheira.danilo.familyrecipes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    @GetMapping
    public String getRecipe() {
        return "API Test!";
    }
}
