package pe.edu.upc.recipes_service.recipes.domain.model.commands;

// recipes.domain.model.commands
public record AddIngredientToRecipeCommand(Long recipeId, Long ingredientId, double amountGrams) { }
