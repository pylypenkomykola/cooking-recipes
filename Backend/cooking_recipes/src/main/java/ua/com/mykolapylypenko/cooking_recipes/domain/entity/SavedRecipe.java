package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.UserRecipeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "saved_recipes", schema = "cooking_recipes")
public class SavedRecipe implements Serializable {

    @EmbeddedId
    private UserRecipeKey userRecipeKey;

    public SavedRecipe() {
    }

    public SavedRecipe(Builder builder) {
        this.userRecipeKey = builder.userRecipeKey;
        this.user = builder.user;
        this.recipe = builder.recipe;
    }

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne
    @MapsId("id_recipe")
    @JoinColumn(name = "id_recipe", referencedColumnName = "id_recipe")
    private Recipe recipe;

    public UserRecipeKey getUserRecipeKey() {
        return userRecipeKey;
    }

    public User getUser() {
        return user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public static final class Builder{
        private UserRecipeKey userRecipeKey;
        private User user;
        private Recipe recipe;

        public Builder() {
        }

        public Builder userRecipeKey(UserRecipeKey userRecipeKey){
            this.userRecipeKey = userRecipeKey;
            return this;
        }

        public Builder user(User user){
            this.user = user;
            return this;
        }

        public Builder recipe(Recipe recipe){
            this.recipe = recipe;
            return this;
        }

        public SavedRecipe build(){
            return new SavedRecipe(this);
        }
    }
}
