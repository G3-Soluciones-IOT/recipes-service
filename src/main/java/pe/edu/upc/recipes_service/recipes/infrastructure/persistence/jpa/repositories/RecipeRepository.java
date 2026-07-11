package pe.edu.upc.recipes_service.recipes.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.recipes_service.recipes.domain.model.aggregates.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    boolean existsByName(String name);

    @Override
    @EntityGraph(attributePaths = {
            "category",
            "recipeType",
            "recipeIngredients",
            "recipeIngredients.ingredient"
    })
    Optional<Recipe> findById(Long id);

    @Override
    @EntityGraph(attributePaths = {
            "category",
            "recipeType",
            "recipeIngredients",
            "recipeIngredients.ingredient"
    })
    List<Recipe> findAll();

    @EntityGraph(attributePaths = {
            "category",
            "recipeType",
            "recipeIngredients",
            "recipeIngredients.ingredient"
    })
    List<Recipe> findAllByCategoryId(Long categoryId);

    @EntityGraph(attributePaths = {
            "category",
            "recipeType",
            "recipeIngredients",
            "recipeIngredients.ingredient"
    })
    List<Recipe> findAllByAssignedToProfileId(int assignedToProfileId);
}
