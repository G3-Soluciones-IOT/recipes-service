package pe.edu.upc.center.jameoFit.recipes.domain.model.commands;

// recipes.domain.model.commands
public record AddIngredientToRecipeCommand(Long recipeId, Long ingredientId, double amountGrams) { }
