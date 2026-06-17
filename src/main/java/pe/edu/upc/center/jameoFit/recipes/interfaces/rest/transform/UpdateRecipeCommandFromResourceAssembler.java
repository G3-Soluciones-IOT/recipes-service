package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.UpdateRecipeCommand;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.CreateRecipeResource;

public class UpdateRecipeCommandFromResourceAssembler {

    public static UpdateRecipeCommand toCommandFromResource(Long recipeId, CreateRecipeResource resource) {
        return new UpdateRecipeCommand(
                recipeId,
                resource.name(),
                resource.description(),
                resource.preparationTime(),
                resource.difficulty(),
                resource.categoryId(),
                resource.recipeTypeId()
        );
    }
}
