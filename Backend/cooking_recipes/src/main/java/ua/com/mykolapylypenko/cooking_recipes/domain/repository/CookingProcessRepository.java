package ua.com.mykolapylypenko.cooking_recipes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.CookingProcess;

@Repository
public interface CookingProcessRepository extends JpaRepository<CookingProcess, Long>, CrudRepository<CookingProcess, Long> {
}
