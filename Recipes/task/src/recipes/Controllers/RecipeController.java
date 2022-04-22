package recipes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipes.Models.Recipe;
import recipes.Models.RecipeDAO;


@RequestMapping("/api")
@RestController
public class RecipeController {

    @Autowired
    private RecipeDAO recipeDAO;

    @PostMapping("/recipe")
    public void postRecipe(@RequestBody Recipe recipe) {
        this.recipeDAO.post(recipe);
    }

    @GetMapping("/recipe")
    public Recipe getRecipe() {
        return this.recipeDAO.get();
    }
}