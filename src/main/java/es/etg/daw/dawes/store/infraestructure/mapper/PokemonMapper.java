package es.etg.daw.dawes.store.infraestructure.mapper;

import es.etg.daw.dawes.store.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.domain.model.Pokemon;
import es.etg.daw.dawes.store.infraestructure.web.mvc.dto.PokemonRequest;
import es.etg.daw.dawes.store.infraestructure.web.mvc.dto.PokemonResponse;

public class PokemonMapper {
    
    public static CreatePokemonCommand toCommand(PokemonRequest request){
        return new CreatePokemonCommand(request.nombre(), 
                                    request.tipo(),request.foto(),
                                    request.precio());
    }

    public static PokemonResponse toResponse (Pokemon pokemon){
        return new PokemonResponse(pokemon.getId(), pokemon.getNombre(), 
                                pokemon.getTipo(), pokemon.getFoto(), 
                                pokemon.getPrecio(), pokemon.getCreatedAt());
    }
}