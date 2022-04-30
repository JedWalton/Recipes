package recipes.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User already exist")
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super();
    }
}