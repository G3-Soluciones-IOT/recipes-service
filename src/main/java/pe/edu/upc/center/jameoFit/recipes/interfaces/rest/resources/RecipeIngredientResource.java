package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

public record RecipeIngredientResource(
        IngredientResource ingredient,
        double amountGrams
) {}