package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class EditPokemonUseCase {
    public Pokemon update(EditPokemonCommand command) {
        // En esta fase de la práctica simulamos la actualización devolviendo el Pokemon
        // con los nuevos valores
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
