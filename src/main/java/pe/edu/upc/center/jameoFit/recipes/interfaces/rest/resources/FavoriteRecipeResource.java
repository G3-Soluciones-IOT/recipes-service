package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources;

public record FavoriteRecipeResource(Long id, Long userId, Long recipeId, String recipeName) {
}
