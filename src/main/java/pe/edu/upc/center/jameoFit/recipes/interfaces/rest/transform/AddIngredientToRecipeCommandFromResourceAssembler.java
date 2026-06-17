package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;


import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.AddIngredientToRecipeCommand;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.AddIngredientToRecipeResource;

public class AddIngredientToRecipeCommandFromResourceAssembler {
    public static AddIngredientToRecipeCommand toCommand(Long recipeId, AddIngredientToRecipeResource resource) {
        return new AddIngredientToRecipeCommand(recipeId, resource.ingredientId(), resource.amountGrams());
    }
}
