package pe.edu.upc.center.jameoFit.recipes.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.jameoFit.recipes.domain.model.aggregates.Recipe;
import pe.edu.upc.center.jameoFit.recipes.domain.model.entities.Category;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    boolean existsByName(String name);
    List<Recipe> findAllByCategoryId(Long categoryId);
    List<Recipe> findAllByAssignedToProfileId(int assignedToProfileId);
}
