package es.etg.daw.dawes.store.pokemon.infraestructure.web.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoPokemonValidator implements ConstraintValidator<NombradoPokemon, String>{

    private static final String STR_BLANCO = " ";
    private static final String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return value == null || value.isEmpty() || (!value.contains (STR_BLANCO) && !value.contains(STR_SALTO)); 
    } 
}