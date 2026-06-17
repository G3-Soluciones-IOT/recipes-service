package pe.edu.upc.center.jameoFit.recipes.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MacronutrientValuesId(Long macronutrientValuesId) {
    public MacronutrientValuesId {
        if(macronutrientValuesId < 0){
            throw new IllegalArgumentException("MacronutrientValues macronutrientValuesId cannot be negative");
        }
    }

    public MacronutrientValuesId() { this(0L); }
}