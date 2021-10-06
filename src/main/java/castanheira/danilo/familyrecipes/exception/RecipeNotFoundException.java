package castanheira.danilo.familyrecipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(Long id) {
        super("Recipe not found with ID " + id);
    }
}
