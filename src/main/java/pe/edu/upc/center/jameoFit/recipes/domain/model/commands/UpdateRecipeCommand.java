package pe.edu.upc.center.jameoFit.recipes.domain.model.commands;

public record UpdateRecipeCommand(
        Long recipeId,
        String name,
        String description,
        int preparationTime,
        String difficulty,
        Long categoryId,
        Long recipeTypeId
) { }
