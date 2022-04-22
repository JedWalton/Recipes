package recipes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipes.Models.Recipe;
import recipes.Models.RecipeDAO;


@RequestMapping("/api/recipe")
@RestController
public class RecipeController {

    private RecipeDAO recipeDAO;

    @PostMapping("/new")
    public void postRecipe(@RequestBody Recipe recipe) {
        this.recipeDAO.post(recipe);
    }

    @GetMapping("/")
    public Recipe getRecipe(long id) {
        return this.recipeDAO.get(id);
    }
}