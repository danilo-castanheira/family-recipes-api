package castanheira.danilo.familyrecipes.service;

import castanheira.danilo.familyrecipes.dto.MessageResponseDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public MessageResponseDTO createRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        return MessageResponseDTO
                .builder()
                .message("Created recipe with ID " + savedRecipe.getId())
                .build();
    }
}
