package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.CreateRecipeTypeCommand;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.CreateRecipeTypeResource;

public class CreateRecipeTypeCommandFromResourceAssembler {

    public static CreateRecipeTypeCommand toCommandFromResource(CreateRecipeTypeResource resource) {
        return new CreateRecipeTypeCommand(resource.name());
    }
}