package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class EditPokemonUseCase {
    public Pokemon update(EditPokemonCommand command) {
        Pokemon pokemon = Pokemon.builder()
                .id(command.id())
                .nombre("Pokemon Modificado")
                .tipo("Normal")
                .foto(command.foto())
                .precio(command.precio())
                .createdAt(LocalDateTime.now())
                .build();

        return pokemon;
    }
}
