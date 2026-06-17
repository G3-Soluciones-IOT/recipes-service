package pe.edu.upc.center.jameoFit.recipes.domain.model.commands;

public record CreateIngredientCommand(
        String name,
        double calories,
        double proteins,
        double fats,
        double carbohydrates,
        Long macronutrientValuesId
) { }