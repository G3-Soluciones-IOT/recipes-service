package pe.edu.upc.center.jameoFit.recipes.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.recipes.domain.model.valueobjects.RecipeNutrition;
import pe.edu.upc.center.jameoFit.recipes.interfaces.rest.resources.RecipeNutritionResource;

public class RecipeNutritionResourceAssembler {
    public static RecipeNutritionResource toResource(RecipeNutrition vo) {
        return new RecipeNutritionResource(vo.calories(), vo.carbs(), vo.proteins(), vo.fats());
    }
}