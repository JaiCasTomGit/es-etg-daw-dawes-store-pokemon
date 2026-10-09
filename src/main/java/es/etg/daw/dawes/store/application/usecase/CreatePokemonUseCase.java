package es.etg.daw.dawes.store.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.domain.model.Pokemon;

public class CreatePokemonUseCase {

    public Pokemon create( CreatePokemonCommand comando){
        
        Pokemon pokemon = Pokemon.builder()
                                 .nombre(comando.nombre())
                                 .tipo(comando.tipo())
                                 .foto(comando.foto())
                                 .precio(comando.precio())
                                 .createdAt(LocalDateTime.now()).build();
        //TODO Faltaría la lógica sobre el pokemon, por ejemplo, almacenarlo en una base de datos.
        return pokemon;
    }
    
}