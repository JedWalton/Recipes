package recipes.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "api/recipe/")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(value = "new")
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe) {
        return Map.of("id", recipeService.add(recipe));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable @Min(1) long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        return ResponseEntity.of(recipe);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteRecipe(@PathVariable @Min(1) long id) {
        boolean status = recipeService.deleteById(id);
        return status ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(404).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateRecipe(@Valid @RequestBody Recipe recipe, @PathVariable long id) {
        boolean status = recipeService.updateById(id, recipe);
        return status ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(404).build();
    }

    @GetMapping(value = "search")
    public ResponseEntity<List<Recipe>> searchCategory(@RequestParam Map<String, String> param) {
        if (param.size() == 1 && param.containsKey("category")) {
            return ResponseEntity.status(200).body(recipeService.findByCategory(param.get("category")));
        }
        if (param.size() == 1 && param.containsKey("name")) {
            return ResponseEntity.status(200).body(recipeService.findByName(param.get("name")));
        }
        return ResponseEntity.status(400).build();

    }
}