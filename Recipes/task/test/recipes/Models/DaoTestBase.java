package recipes.Models;

import org.junit.Before;


public abstract class DaoTestBase<T extends Dao> {

    private T instance;

    protected abstract T createInstance();

    @Before
    public void setUp() {
        this.instance = createInstance();
    }

}