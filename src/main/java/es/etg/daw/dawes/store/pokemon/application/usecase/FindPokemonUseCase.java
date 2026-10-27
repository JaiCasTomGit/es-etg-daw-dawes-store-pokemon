package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class FindPokemonUseCase {

    private final PokemonRepository pokemonRepository;
    
    public List<Pokemon> findAll(){

        return pokemonRepository.getAll();
    }
}
