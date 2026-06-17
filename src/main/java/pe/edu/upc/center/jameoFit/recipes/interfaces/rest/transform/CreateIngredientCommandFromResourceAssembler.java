package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.CreateIngredientCommand;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.CreateIngredientResource;

public class CreateIngredientCommandFromResourceAssembler {

    public static CreateIngredientCommand toCommandFromResource(CreateIngredientResource resource) {
        return new CreateIngredientCommand(
                resource.name(),
                resource.calories(),
                resource.proteins(),
                resource.fats(),
                resource.carbohydrates(),
                resource.macronutrientValuesId()
        );
    }
}