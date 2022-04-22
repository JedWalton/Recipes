package recipes.Models;

import org.springframework.stereotype.Component;

@Component
public class RecipeDAO implements Dao<Recipe>{

    Recipe recipe;

    public RecipeDAO() {
    }

    @Override
    public boolean post(Recipe recipe) {
        try {
            this.recipe = recipe;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Recipe get() {
        return recipe;
    }
}