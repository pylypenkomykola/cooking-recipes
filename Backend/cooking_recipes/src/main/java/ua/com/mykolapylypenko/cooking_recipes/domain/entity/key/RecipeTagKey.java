package ua.com.mykolapylypenko.cooking_recipes.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeTagKey implements Serializable {

    @Column(name = "id_recipe")
    private Long recipeId;

    @Column(name = "id_tag")
    private Long tagId;

    public RecipeTagKey() {
    }

    public RecipeTagKey(Long recipeId, Long tagId) {
        this.recipeId = recipeId;
        this.tagId = tagId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeTagKey that = (RecipeTagKey) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, tagId);
    }
}
