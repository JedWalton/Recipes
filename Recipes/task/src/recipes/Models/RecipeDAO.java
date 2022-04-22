package recipes.Models;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RecipeDAO implements Dao<Recipe>{

    //    Recipe recipe;
    Map<Long, Recipe> recipes = new HashMap<>();

    public RecipeDAO() {

    }

    @Override
    public long post(Recipe recipe) {
        try {
            this.recipes.put((long) recipes.size() + 1, recipe);
        } catch(Exception e) {
            e.printStackTrace();
//            return false;
        }
        return (long) recipes.size();
    }

    @Override
    public Recipe get(long id) {
        return recipes.get(id);
    }
}
