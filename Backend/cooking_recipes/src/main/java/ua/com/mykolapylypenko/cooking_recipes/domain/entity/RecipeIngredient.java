package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeCookingIngredientKey;
import ua.com.mykolapylypenko.cooking_recipes.public_info.PublicVariables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class RecipeIngredient implements Serializable {

    @EmbeddedId
    private RecipeCookingIngredientKey key;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Builder builder) {
        this.key = builder.key;
        this.recipe = builder.recipe;
        this.cookingIngredient = builder.cookingIngredient;
    }

    @ManyToOne
    @MapsId("id_recipe")
    @JoinColumn(name = "id_recipe", referencedColumnName = "id_recipe")
    private Recipe recipe;

    @ManyToOne
    @MapsId("id_cooking_ingredient")
    @JoinColumn(name = "id_cooking_ingredient", referencedColumnName = "id_cooking_ingredient")
    private CookingIngredient cookingIngredient;

    public Recipe getRecipe() {
        return recipe;
    }

    public CookingIngredient getCookingIngredient() {
        return cookingIngredient;
    }

    public static final class Builder{
        private RecipeCookingIngredientKey key;
        private Recipe recipe;
        private CookingIngredient cookingIngredient;

        public Builder() {
        }

        public Builder key(RecipeCookingIngredientKey key){
            this.key = key;
            return this;
        }

        public Builder recipe(Recipe recipe){
            this.recipe = recipe;
            return this;
        }

        public Builder cookingIngredient(CookingIngredient cookingIngredient){
            this.cookingIngredient = cookingIngredient;
            return this;
        }

        public RecipeIngredient build(){
            return new RecipeIngredient(this);
        }
    }
}
