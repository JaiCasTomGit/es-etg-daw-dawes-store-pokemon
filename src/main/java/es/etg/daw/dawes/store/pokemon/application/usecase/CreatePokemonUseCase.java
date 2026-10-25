package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class CreatePokemonUseCase {

    public Pokemon create( CreatePokemonCommand comando){
        
        Pokemon pokemon = Pokemon.builder()
                                 .nombre(comando.nombre())
                                 .tipo(comando.tipo())
                                 .foto(comando.foto())
                                 .precio(comando.precio())
                                 .createdAt(LocalDateTime.now()).build();
        return pokemon;
    }
    
}