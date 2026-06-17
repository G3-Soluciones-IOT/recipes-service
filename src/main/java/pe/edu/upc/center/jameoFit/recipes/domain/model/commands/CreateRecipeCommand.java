package pe.edu.upc.center.jameoFit.recipes.domain.model.commands;

public record CreateRecipeCommand(
        String name,
        String description,
        int preparationTime,
        String difficulty,
        Long categoryId,
        Long recipeTypeId,
        // Nuevos campos para manejar la lÃ³gica de plantillas/asignaciÃ³n
        Long createdByNutritionistId, // ID del nutricionista que la creÃ³ (null si es receta personal)
        Integer assignedToProfileId   // ID del perfil al que estÃ¡ asignada (null si es plantilla)
) {}