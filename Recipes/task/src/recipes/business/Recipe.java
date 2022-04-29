package recipes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    @JsonIgnore
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "name can not blank")
    private String name;

    @NotBlank(message = "description can not blank")
    private String description;

    @NotBlank(message = "category can not blank")
    private String category;

    @UpdateTimestamp
    private LocalDateTime date;

    @NotEmpty(message = "ingredients can not empty")
    @Size(min = 1, message = "ingredients must >= 1")
    @ElementCollection
    private List<String> ingredients;

    @NotEmpty(message = "directions can not empty")
    @Size(min = 1, message = "directions must >= 1")
    @ElementCollection
    private List<String> directions;

    public void copyOf(Recipe recipe) {
        name = recipe.name;
        description = recipe.description;
        category = recipe.category;
        ingredients = recipe.ingredients;
        directions = recipe.directions;
    }
}