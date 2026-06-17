package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.entities.FavoriteRecipe;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.FavoriteRecipeResource;

import java.util.List;
import java.util.stream.Collectors;

public class FavoriteRecipeResourceFromEntityAssembler {

    public static FavoriteRecipeResource toResource(FavoriteRecipe favoriteRecipe) {
        return new FavoriteRecipeResource(
                favoriteRecipe.getId(),
                favoriteRecipe.getUserId(),
                favoriteRecipe.getRecipe().getId(),
                favoriteRecipe.getRecipe().getName()
        );
    }

    public static List<FavoriteRecipeResource> toResources(List<FavoriteRecipe> favorites) {
        return favorites.stream().map(FavoriteRecipeResourceFromEntityAssembler::toResource).collect(Collectors.toList());
    }
}