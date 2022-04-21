package recipes.Models;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t, String[] params);

    boolean delete(T t);

    // ADDED FOR STAGE 1/5
    T get();
}