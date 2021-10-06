package castanheira.danilo.familyrecipes.dto.request;

import castanheira.danilo.familyrecipes.entity.Source;
import castanheira.danilo.familyrecipes.enums.Difficulty;
import castanheira.danilo.familyrecipes.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    private LocalDate registrationDate;

    @Valid
    private List<Source> sources;

    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String ingredients;

    private String makes;

    @Size(min = 0, max = 99)
    private Integer cooksIn;

    private String wayOfDoing;

    private String tips;
}
