package recipes.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class RecipeDAO implements Dao<Recipe>{

    private List<Recipe> recipes = new ArrayList<>();

    //ADDED FOR STAGE 1/5
    Recipe recipe;

    public RecipeDAO() {

    }

    // COMMENTED OUT FOR STAGE 1/5
    @Override
    public Optional<Recipe> get(long id) {
//        return Optional.ofNullable(recipes.get((int) id));
        return Optional.ofNullable(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipes;
    }

    @Override
    public boolean save(Recipe recipe) {
        try {
            this.recipes.add(recipe);
            //ADDED FOR STAGE 1/5
            this.recipe = recipe;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Recipe recipe, String[] params) {
//        try {
//            recipe.setName(Objects.requireNonNull(
//                    params[0], "Name cannot be null"));
//            recipe.setDescription(Objects.requireNonNull(
//                    params[1], "Description cannot be null"));
//            recipe.setIngredients(Objects.requireNonNull(
//                    params[2], "Ingredients cannot be null"));
//            recipe.setDirections(Objects.requireNonNull(
//                    params[3], "Directions cannot be null"));
//
//            recipes.add(recipe);
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }

    @Override
    public boolean delete(Recipe recipe) {
        try {
            recipes.remove(recipe);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    //ADDED FOR STAGE 1/5
    @Override
    public Recipe get() {
        return recipe;
    }
}
