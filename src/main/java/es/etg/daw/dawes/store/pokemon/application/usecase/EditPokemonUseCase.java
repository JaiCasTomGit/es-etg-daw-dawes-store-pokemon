package es.etg.daw.dawes.store.pokemon.application.usecase;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class EditPokemonUseCase {
    
    private final PokemonRepository pokemonRepository;
    
    public Pokemon update(EditPokemonCommand command) {
        Pokemon resultado = null;

        Pokemon pokemon = pokemonRepository.getById(command.id()).orElse(null);

        if (pokemon != null){
            pokemon.setFoto(command.foto());
            pokemon.setPrecio(command.precio());
            resultado = pokemonRepository.save(pokemon);
        }


        return resultado;
    }
}
