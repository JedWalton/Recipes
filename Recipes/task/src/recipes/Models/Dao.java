package recipes.Models;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {

    long post(T t);

    T get(long id);
}