package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.RecipeIngredient;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeCookingIngredientKey;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeCookingIngredientKey>, CrudRepository<RecipeIngredient, RecipeCookingIngredientKey> {
}
