package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

import java.util.List;

public record RecipeResource(
        Long id,
        // ðŸ†• Nuevos campos que reemplazan a 'userId' para claridad
        Long createdByNutritionistId, // ID del nutricionista que creÃ³ la plantilla (null si es personal)
        Integer assignedToProfileId,   // ID del perfil al que estÃ¡ asignada (null si es plantilla)
        String name,
        String description,
        int preparationTime,
        String difficulty,
        String categoryName,
        String recipeTypeName,
        List<RecipeIngredientResource> ingredients
) {}

