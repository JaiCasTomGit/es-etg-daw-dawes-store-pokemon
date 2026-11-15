package es.etg.daw.dawes.store.pokemon.application.usecase;

import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class DeletePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public void delete(int id){
        pokemonRepository.getById(id)
            .orElseThrow(()-> new PokemonNotFoundException(id));
        pokemonRepository.deleteById(id); 
    }
}
