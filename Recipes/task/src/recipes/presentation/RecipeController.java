package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecipeController {
    final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe/new")
    public Object postRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.save(recipe);
        return String.format("{\"id\": %d}", newRecipe.getId());
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {
        return recipeService.findRecipeById(id);
    }

    @DeleteMapping("/recipe/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable long id) {
        recipeService.deleteRecipeById(id);
    }
}