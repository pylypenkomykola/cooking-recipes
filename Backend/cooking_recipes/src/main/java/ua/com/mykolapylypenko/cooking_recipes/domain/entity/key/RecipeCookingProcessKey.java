package ua.com.mykolapylypenko.cooking_recipes.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeCookingProcessKey implements Serializable {

    @Column(name = "id_recipe")
    private Long recipeId;

    @Column(name = "id_cooking_process")
    private Long cookingProcessId;

    public RecipeCookingProcessKey() {
    }

    public RecipeCookingProcessKey(Long recipeId, Long cookingProcessId) {
        this.recipeId = recipeId;
        this.cookingProcessId = cookingProcessId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getCookingProcessId() {
        return cookingProcessId;
    }

    public void setCookingProcessId(Long cookingProcessId) {
        this.cookingProcessId = cookingProcessId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCookingProcessKey that = (RecipeCookingProcessKey) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(cookingProcessId, that.cookingProcessId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, cookingProcessId);
    }
}
