package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

public record CreateRecipeResource(
        String name,
        String description,
        int preparationTime,
        String difficulty,
        Long categoryId,
        Long recipeTypeId
) {}