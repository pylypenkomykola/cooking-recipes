package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.PostedRecipe;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.UserRecipeKey;

@Repository
public interface PostedRecipeRepository extends JpaRepository<PostedRecipe, UserRecipeKey>, CrudRepository<PostedRecipe, UserRecipeKey> {
}
