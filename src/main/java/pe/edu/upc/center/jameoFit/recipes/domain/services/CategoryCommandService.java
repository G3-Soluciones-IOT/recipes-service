package pe.edu.upc.center.jameoFit.recipes.domain.services;

import pe.edu.upc.center.jameoFit.recipes.domain.model.commands.CreateCategoryCommand;

public interface CategoryCommandService {
    Long handle(CreateCategoryCommand command);
}