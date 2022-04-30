package recipes.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipes.user.RecipesUserDetails;


@Component(value = "recipeOwnershipEvaluator")
public class RecipeOwnershipEvaluator {

    private final RecipeService recipeService;

    @Autowired
    public RecipeOwnershipEvaluator(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public boolean isOwner(long id, RecipesUserDetails userDetails) {
        Recipe toModify = recipeService.get(id);
        return toModify.getUser().getEmail().equals(userDetails.getUsername());
    }
}