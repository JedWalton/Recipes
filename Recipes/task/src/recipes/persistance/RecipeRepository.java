package recipes.persistance;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import recipes.business.Recipe;

import java.util.List;

@Component
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
}