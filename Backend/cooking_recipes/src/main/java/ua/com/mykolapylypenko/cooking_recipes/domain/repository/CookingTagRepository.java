package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.CookingTag;

@Repository
public interface CookingTagRepository extends JpaRepository<CookingTag, Long>, CrudRepository<CookingTag, Long> {
}
