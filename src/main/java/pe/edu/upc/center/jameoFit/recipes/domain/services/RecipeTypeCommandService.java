package pe.edu.upc.center.jameoFit.recipes.domain.services;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.CreateRecipeTypeCommand;

public interface RecipeTypeCommandService {
    Long handle(CreateRecipeTypeCommand command);
}