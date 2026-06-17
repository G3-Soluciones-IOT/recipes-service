package pe.edu.upc.center.jameoFit.recipes.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.jameoFit.recipes.domain.model.aggregates.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    boolean existsByName(String name);
}
