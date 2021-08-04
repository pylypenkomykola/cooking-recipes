package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeTagKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_tags", schema = "cooking_recipes")
public class RecipeTag implements Serializable {

    @EmbeddedId
    private RecipeTagKey key;

    public RecipeTag() {
    }

    private RecipeTag(Builder builder) {
        this.key = builder.key;
        this.recipe = builder.recipe;
        this.cookingTag = builder.cookingTag;
    }

    @ManyToOne
    @MapsId("id_recipe")
    @JoinColumn(name = "id_recipe", referencedColumnName = "id_recipe")
    private Recipe recipe;

    @ManyToOne
    @MapsId("id_tag")
    @JoinColumn(name = "id_tag", referencedColumnName = "id_tag")
    private CookingTag cookingTag;

    public RecipeTagKey getKey() {
        return key;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public CookingTag getCookingTag() {
        return cookingTag;
    }

    private static final class Builder{
        private RecipeTagKey key;
        private Recipe recipe;
        private CookingTag cookingTag;

        public Builder() {
        }

        public Builder key(RecipeTagKey key){
            this.key = key;
            return this;
        }

        public Builder recipe(Recipe recipe){
            this.recipe = recipe;
            return this;
        }

        public Builder cookingTag(CookingTag cookingTag){
            this.cookingTag = cookingTag;
            return this;
        }

        public RecipeTag build(){
            return new RecipeTag(this);
        }
    }

}
