package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients", schema = "cooking_recipes")
public class RecipeIngredient implements Serializable {

    public RecipeIngredient() {
    }

    public RecipeIngredient(Builder builder) {
        this.recipe = recipe;
        this.cookingIngredient = cookingIngredient;
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
        private Recipe recipe;
        private CookingIngredient cookingIngredient;

        public Builder() {
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
