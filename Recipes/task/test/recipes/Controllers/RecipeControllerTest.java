package recipes.Controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import recipes.Models.Recipe;
import recipes.Models.RecipeDAO;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @InjectMocks
    RecipeController recipeController;

    @Mock
    RecipeDAO recipeDAO;

    @Test
    void postRecipe() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(recipeDAO.post(any(Recipe.class))).thenReturn(true);

        Recipe recipe = new Recipe("Pizza", "blah", "bablah", "ababh");

    }

    @Test
    void getRecipe() {
        Recipe recipe = new Recipe("Pizza",
                "Tasty cheesy pizza",
                "dough, pizza, tomato puree",
                "1) flatten dough 2) apply tomato puree 3) apply cheese 4) Bake");
        recipeDAO.post(recipe);
        when(recipeDAO.get()).thenReturn(recipe);

        Recipe result = recipeDAO.get();
        assertEquals(result, recipe);
        assertEquals(result.getName(), "Pizza");
        assertEquals(result.getDescription(), "Tasty cheesy pizza");
        assertEquals(result.getIngredients(), "dough, pizza, tomato puree");
        assertEquals(result.getDirections(), "1) flatten dough 2) apply tomato puree 3) apply cheese 4) Bake");
    }
}