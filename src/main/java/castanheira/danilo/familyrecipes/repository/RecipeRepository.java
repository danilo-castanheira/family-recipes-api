package castanheira.danilo.familyrecipes.repository;

import castanheira.danilo.familyrecipes.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
