package es.etg.daw.dawes.store.pokemon.domain.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T, ID> {

    T save(T t);
    List<T> getAll();
    Optional<T> getById(ID id); 
    void deleteById(ID id);
}
