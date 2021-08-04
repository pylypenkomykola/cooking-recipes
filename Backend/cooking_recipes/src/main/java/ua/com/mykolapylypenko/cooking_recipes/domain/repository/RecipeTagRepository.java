package ua.com.mykolapylypenko.cooking_recipes.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.RecipeTag;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.key.RecipeTagKey;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTag, RecipeTagKey>, CrudRepository<RecipeTag, RecipeTagKey> {
}
