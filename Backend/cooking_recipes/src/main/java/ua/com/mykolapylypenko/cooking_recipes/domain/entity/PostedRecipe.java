package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posted_recipes", schema = "cooking_recipes")
public class PostedRecipe implements Serializable {

    public PostedRecipe() {
    }

    public PostedRecipe(Builder builder) {
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

    public User getUser() {
        return user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public static final class Builder{
        private User user;
        private Recipe recipe;

        public Builder() {
        }

        public Builder user(User user){
            this.user = user;
            return this;
        }

        public Builder recipe(Recipe recipe){
            this.recipe = recipe;
            return this;
        }

        public PostedRecipe build(){
            return new PostedRecipe(this);
        }
    }
}
