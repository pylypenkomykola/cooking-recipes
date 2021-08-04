package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.RecipeProcess;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeCookingProcessKey;

@Repository
public interface RecipeProcessRepository extends JpaRepository<RecipeProcess, RecipeCookingProcessKey>, CrudRepository<RecipeProcess, RecipeCookingProcessKey> {
}
