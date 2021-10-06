package castanheira.danilo.familyrecipes.controller;

import castanheira.danilo.familyrecipes.dto.MessageResponseDTO;
import castanheira.danilo.familyrecipes.dto.request.RecipeDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.exception.RecipeNotFoundException;
import castanheira.danilo.familyrecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createRecipe(@RequestBody @Valid RecipeDTO recipeDTO) {
        return recipeService.createRecipe(recipeDTO);
    }

    @GetMapping
    public List<RecipeDTO> listAll() {
        return recipeService.listAll();
    }

    @GetMapping("/{id}")
    public RecipeDTO findById(@PathVariable Long id) throws RecipeNotFoundException {
        return recipeService.findById(id);
    }
}
