package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import ua.com.mykolapylypenko.cooking_recipes.public_info.*;

@Entity
@Table(name = "cooking_ingredients", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class CookingIngredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cooking_ingredient")
    private Long cookingIngredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "amount_type")
    private String amountType;

    public CookingIngredient() {
    }

    public CookingIngredient(Builder builder) {
        this.cookingIngredientId = builder.cookingIngredientId;
        this.name = builder.name;
        this.amount = builder.amount;
        this.amountType = builder.amountType;
    }

    @OneToMany(mappedBy = "cookingIngredient")
    private Set<RecipeIngredient> recipeIngredients;

    public Long getCookingIngredientId() {
        return cookingIngredientId;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public static final class Builder{
        private Long cookingIngredientId;
        private String name;
        private Integer amount;
        private String amountType;

        public Builder() {
        }

        public Builder cookingIngredientId(Long cookingIngredientId){
            this.cookingIngredientId = cookingIngredientId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder amount(Integer amount){
            this.amount = amount;
            return this;
        }

        public Builder amountType(String amountType){
            this.amountType = amountType;
            return this;
        }

        public CookingIngredient build(){
            return new CookingIngredient(this);
        }
    }
}
