package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.CreateFavoriteRecipeCommand;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.CreateFavoriteRecipeResource;

public class CreateFavoriteRecipeCommandFromResourceAssembler {
    public static CreateFavoriteRecipeCommand toCommandFromResource(CreateFavoriteRecipeResource resource) {
        return new CreateFavoriteRecipeCommand(resource.userId(), resource.recipeId());
    }
}