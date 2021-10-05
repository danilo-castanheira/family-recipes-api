package castanheira.danilo.familyrecipes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    VERY_EASY("Very Easy"),
    EASY ("Easy"),
    NOT_TOO_TRICKY("Not too tricky");

    private final String description;
}
