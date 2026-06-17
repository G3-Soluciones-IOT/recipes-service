package pe.edu.upc.center.jameoFit.recipes.domain.services;

import pe.edu.upc.center.jameoFit.recipes.domain.model.entities.Category;
import pe.edu.upc.center.jameoFit.recipes.domain.model.queries.GetAllCategoriesQuery;
import pe.edu.upc.center.jameoFit.recipes.domain.model.queries.GetCategoryByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    List<Category> handle(GetAllCategoriesQuery query);
    Optional<Category> handle(GetCategoryByIdQuery query);
}