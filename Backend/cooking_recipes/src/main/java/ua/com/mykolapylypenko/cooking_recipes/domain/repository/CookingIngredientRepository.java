package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.CookingIngredient;

@Repository
public interface CookingIngredientRepository extends JpaRepository<CookingIngredient, Long>, CrudRepository<CookingIngredient, Long> {
}
