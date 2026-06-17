package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

public record CreateIngredientResource(String name, double calories, double proteins, double fats,
                                       double carbohydrates, Long macronutrientValuesId) {
}