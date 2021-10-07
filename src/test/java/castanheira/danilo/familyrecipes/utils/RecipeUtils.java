package castanheira.danilo.familyrecipes.utils;

import castanheira.danilo.familyrecipes.dto.request.RecipeDTO;
import castanheira.danilo.familyrecipes.entity.Recipe;
import castanheira.danilo.familyrecipes.entity.Source;
import castanheira.danilo.familyrecipes.enums.Difficulty;
import castanheira.danilo.familyrecipes.enums.FoodCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class RecipeUtils {
    private static final long RECIPE_ID = 1L;
    private static final String NAME = "Receita";
    private static final String DESCRIPTION = "Descricao da receita";

    public static RecipeDTO createFakeDTO() {
        return RecipeDTO.builder()
                .name(NAME)
                .description(DESCRIPTION)
                .build();
    }

    public static Recipe createFakeEntity() {
        return Recipe.builder()
                .id(RECIPE_ID)
                .name(NAME)
                .description(DESCRIPTION)
                .build();
    }
}
