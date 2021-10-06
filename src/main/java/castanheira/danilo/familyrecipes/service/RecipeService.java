package castanheira.danilo.familyrecipes.service;

import castanheira.danilo.familyrecipes.dto.MessageResponseDTO;
import castanheira.danilo.familyrecipes.dto.request.RecipeDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.mapper.RecipeMapper;
import castanheira.danilo.familyrecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public MessageResponseDTO createRecipe(RecipeDTO recipeDTO) {
        Recipe recipeToSave = recipeMapper.toModel(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipeToSave);
        return MessageResponseDTO
                .builder()
                .message("Created recipe with ID " + savedRecipe.getId())
                .build();
    }

    public List<RecipeDTO> listAll() {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }
}