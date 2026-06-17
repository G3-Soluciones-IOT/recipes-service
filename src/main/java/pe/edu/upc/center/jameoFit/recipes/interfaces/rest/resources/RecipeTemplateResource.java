package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

import java.util.List;

public record RecipeTemplateResource(
        Long id,
        String name,
        String description,
        String category,
        Long createdByNutritionistId,
        String nutritionistName,
        Integer preparationTime,
        String difficulty,
        List<RecipeIngredientResource> ingredients
) {
}
