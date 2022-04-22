package recipes.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipe;

    @BeforeEach
    void setUp() {
        this.recipe = new Recipe();
    }

    @Test
    void getName() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        assertEquals(this.recipe.getName(), "Pizza");
    }

    @Test
    void setName() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        this.recipe.setName("Spaghetti");
        assertEquals(this.recipe.getName(), "Spaghetti");
    }

    @Test
    void getDescription() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        assertEquals(this.recipe.getDescription(), "desc");
    }

    @Test
    void setDescription() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        this.recipe.setDescription("changed description");
        assertEquals(this.recipe.getDescription(), "changed description");
    }

    @Test
    void getIngredients() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        assertEquals(this.recipe.getIngredients(), "ingredients");
    }

    @Test
    void setIngredients() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        this.recipe.setIngredients("changed ingredients");
        assertEquals(this.recipe.getIngredients(), "changed ingredients");
    }

    @Test
    void getDirections() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        assertEquals(this.recipe.getDirections(), "directions");
    }

    @Test
    void setDirections() {
        this.recipe = new Recipe("Pizza", "desc", "ingredients", "directions");
        this.recipe.setDirections("changed directions");
        assertEquals(this.recipe.getDirections(), "changed directions");
    }
}