package recipes.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDAOTest extends DaoTestBase<RecipeDAO> {

    @Override
    protected RecipeDAO createInstance() {
        return new RecipeDAO();
    }

    @Test
    void post() {
        RecipeDAO Dao = new RecipeDAO();
        assertTrue(Dao.post(new Recipe("name", "desc", "ing", "dir")));
    }

    @Test
    void get() {
        RecipeDAO Dao = new RecipeDAO();
        Recipe recipe = new Recipe("name", "desc", "ing", "dir");
        Dao.post(recipe);
        assertEquals(Dao.get(), recipe);
    }

}