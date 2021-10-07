package castanheira.danilo.familyrecipes.service;

import castanheira.danilo.familyrecipes.dto.MessageResponseDTO;
import castanheira.danilo.familyrecipes.dto.request.RecipeDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static castanheira.danilo.familyrecipes.utils.RecipeUtils.createFakeDTO;
import static castanheira.danilo.familyrecipes.utils.RecipeUtils.createFakeEntity;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @Test
    void testGivenRecipeDTOThenReturnSavedMessage() {
        RecipeDTO recipeDTO = createFakeDTO();
        Recipe expectedSavedRecipe = createFakeEntity();

        Mockito.when(recipeRepository.save(any(Recipe.class))).thenReturn(expectedSavedRecipe);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedRecipe.getId());
        MessageResponseDTO successMessage = recipeService.createRecipe(recipeDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created recipe with ID " + id)
                .build();
    }
}
