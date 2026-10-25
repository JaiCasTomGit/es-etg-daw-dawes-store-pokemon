package es.etg.daw.dawes.store.pokemon.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.DeletePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.EditPokemonService;
import es.etg.daw.dawes.store.pokemon.application.usecase.CreatePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.DeletePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.FindPokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.EditPokemonUseCase;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PokemonConfig {

    @Bean
    public CreatePokemonUseCase createPokemonUseCase() {
        return new CreatePokemonUseCase();
    }

    @Bean
    public CreatePokemonService createPokemonService() {
        return new CreatePokemonService(createPokemonUseCase());
    }

    @Bean 
    public FindPokemonUseCase findPokemonUseCase(){
        return new FindPokemonUseCase();
    }

    @Bean 
    public FindPokemonService findPokemonService(){
        return new FindPokemonService(findPokemonUseCase());
    }

    @Bean 
    public DeletePokemonUseCase deletePokemonUseCase(){
        return new DeletePokemonUseCase();
    }

    @Bean 
    public DeletePokemonService deletePokemonService(){
        return new DeletePokemonService(deletePokemonUseCase());
    }

    @Bean
    public EditPokemonUseCase editPokemonUseCase() {
        return new EditPokemonUseCase();
    }

    @Bean
    public EditPokemonService editPokemonService() {
        return new EditPokemonService(editPokemonUseCase());
    }

}
