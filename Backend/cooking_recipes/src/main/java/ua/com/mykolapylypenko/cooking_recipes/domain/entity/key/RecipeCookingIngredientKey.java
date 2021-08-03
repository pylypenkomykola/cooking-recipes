package ua.com.mykolapylypenko.cooking_recipes.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeCookingIngredientKey implements Serializable {

    @Column(name = "id_recipe")
    private Long recipeId;

    @Column(name = "id_cooking_ingredient")
    private Long cookingIngredientId;

    public RecipeCookingIngredientKey() {
    }

    public RecipeCookingIngredientKey(Long recipeId, Long cookingIngredientId) {
        this.recipeId = recipeId;
        this.cookingIngredientId = cookingIngredientId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getCookingIngredientId() {
        return cookingIngredientId;
    }

    public void setCookingIngredientId(Long cookingIngredientId) {
        this.cookingIngredientId = cookingIngredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCookingIngredientKey that = (RecipeCookingIngredientKey) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(cookingIngredientId, that.cookingIngredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, cookingIngredientId);
    }
}
