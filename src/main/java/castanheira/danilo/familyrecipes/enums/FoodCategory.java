package castanheira.danilo.familyrecipes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodCategory {
    VEGETARIAN("Vegetarian");

    private final String description;
}
