package recipes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import recipes.Models.Recipe;
import recipes.Models.RecipeDAO;

import java.net.URI;


@RequestMapping("/api")
@RestController
public class RecipeController {

    @Autowired
    private RecipeDAO recipeDAO;

    @PostMapping("/recipe")
    public /*ResponseEntity<Object>*/ void postRecipe(@RequestBody Recipe recipe) {
        this.recipeDAO.save(recipe);
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(recipe.getName())
                .toUri();

//        return ResponseEntity.created(location).build();
    }

    @GetMapping("/recipe")
    public Recipe getRecipe() {
        return this.recipeDAO.get();
    }
}