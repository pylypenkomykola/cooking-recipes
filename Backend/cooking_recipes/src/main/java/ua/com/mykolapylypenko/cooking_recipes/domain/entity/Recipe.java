package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.public_info.PublicVariables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "recipes", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long recipeId;

    @Column(name = "portions_amount")
    private Integer portionAmount;

    @Column(name = "name")
    private String recipeName;

    public Recipe(){

    }

    private Recipe(Builder builder){
        this.portionAmount = builder.portionAmount;
        this.recipeName = builder.recipeName;
    }

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeProcess> recipeProcess;

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeTag> recipeTag;

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> recipeIngredient;

    @OneToMany(mappedBy = "recipe")
    private Set<SavedRecipe> savedRecipes;

    @OneToMany(mappedBy = "recipe")
    private Set<PostedRecipe> postedRecipes;

    public Long getRecipeId() {
        return recipeId;
    }

    public Integer getPortionAmount() {
        return portionAmount;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Set<RecipeProcess> getRecipeProcess() {
        return recipeProcess;
    }

    public Set<RecipeTag> getRecipeTag() {
        return recipeTag;
    }

    public Set<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public Set<SavedRecipe> getSavedRecipes() {
        return savedRecipes;
    }

    public Set<PostedRecipe> getPostedRecipes() {
        return postedRecipes;
    }

    public static final class Builder{
        private Integer portionAmount;
        private String recipeName;

        public Builder(){

        }

        public Builder portionAmount(Integer portionAmount){
            this.portionAmount = portionAmount;
            return this;
        }

        public Builder recipeName(String recipeName){
            this.recipeName = recipeName;
            return this;
        }

        public Recipe build(){
            return new Recipe(this);
        }
    }
}
