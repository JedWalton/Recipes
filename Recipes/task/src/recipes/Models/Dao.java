package recipes.Models;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {

    boolean post(T t);

    T get();

}