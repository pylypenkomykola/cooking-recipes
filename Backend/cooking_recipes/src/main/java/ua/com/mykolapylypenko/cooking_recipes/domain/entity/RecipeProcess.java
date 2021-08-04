package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeCookingProcessKey;
import ua.com.mykolapylypenko.cooking_recipes.public_info.PublicVariables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_processes", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class RecipeProcess implements Serializable {
    @EmbeddedId
    private RecipeCookingProcessKey key;

    @Column(name = "position")
    private Integer position;

    @ManyToOne
    @MapsId("id_cooking_process")
    @JoinColumn(name = "id_cooking_process", referencedColumnName = "id_cooking_process")
    private CookingProcess cookingProcess;

    @ManyToOne
    @MapsId("id_recipe")
    @JoinColumn(name = "id_recipe", referencedColumnName = "id_recipe")
    private Recipe recipe;

    public RecipeProcess() {
    }

    public RecipeProcess(Builder builder) {
        this.key = builder.key;
        this.position = builder.position;
        this.cookingProcess = builder.cookingProcess;
        this.recipe = builder.recipe;
    }

    public RecipeCookingProcessKey getKey() {
        return key;
    }

    public Integer getPosition() {
        return position;
    }

    public CookingProcess getCookingProcess() {
        return cookingProcess;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public static final class Builder{
        private RecipeCookingProcessKey key;
        private Integer position;
        private CookingProcess cookingProcess;
        private Recipe recipe;

        public Builder key(RecipeCookingProcessKey key){
            this.key = key;
            return this;
        }

        public Builder position(Integer position){
            this.position = position;
            return this;
        }

        public Builder cookingProcess(CookingProcess cookingProcess){
            this.cookingProcess = cookingProcess;
            return this;
        }

        public Builder recipe(Recipe recipe){
            this.recipe = recipe;
            return this;
        }

        public RecipeProcess build(){
            return new RecipeProcess(this);
        }
    }
}
