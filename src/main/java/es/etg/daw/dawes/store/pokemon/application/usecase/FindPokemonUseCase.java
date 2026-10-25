package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class FindPokemonUseCase {
    
    public List<Pokemon> findAll(){

        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon(1, "Pikachu", "Eléctrico", "1", 1, LocalDateTime.now()));
        lista.add(new Pokemon(2, "Squirtle", "Agua", "2", 2, LocalDateTime.now()));
        lista.add(new Pokemon(3, "Charmander", "Fuego", "3", 3, LocalDateTime.now()));
        return lista;
    }
}
