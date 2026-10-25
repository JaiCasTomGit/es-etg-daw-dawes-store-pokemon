package es.etg.daw.dawes.store.pokemon.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true) 
public class CreatePokemonCommand {
    
    private String nombre;
    private String tipo;
    private String foto;
    private double precio;
}
