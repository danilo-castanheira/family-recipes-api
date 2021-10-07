package castanheira.danilo.familyrecipes.service;

import castanheira.danilo.familyrecipes.dto.MessageResponseDTO;
import castanheira.danilo.familyrecipes.dto.request.RecipeDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.exception.RecipeNotFoundException;
import castanheira.danilo.familyrecipes.mapper.RecipeMapper;
import castanheira.danilo.familyrecipes.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RecipeService {
    private RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    /* Unnecessary if using @AllArgsConstructor
    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    */

    public MessageResponseDTO createRecipe(RecipeDTO recipeDTO) {
        Recipe recipeToSave = recipeMapper.toModel(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipeToSave);
        return createMessageResponse(savedRecipe.getId(), "Created recipe with ID ");
    }

    public List<RecipeDTO> listAll() {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RecipeDTO findById(Long id) throws RecipeNotFoundException {
        /*
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isEmpty()) {
            throw new RecipeNotFoundException(id);
        }
        return recipeMapper.toDTO(optionalRecipe.get());
        */

        Recipe recipe = verifyIfExists(id);
        return recipeMapper.toDTO(recipe);
    }

    public void deleteById(Long id) throws RecipeNotFoundException {
        verifyIfExists(id);
        recipeRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, RecipeDTO recipeDTO) throws RecipeNotFoundException {
        verifyIfExists(id);

        Recipe recipeToUpdate = recipeMapper.toModel(recipeDTO);
        Recipe updatedRecipe = recipeRepository.save(recipeToUpdate);
        return createMessageResponse(updatedRecipe.getId(), "Updated recipe with ID ");
    }

    private Recipe verifyIfExists(Long id) throws RecipeNotFoundException {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}