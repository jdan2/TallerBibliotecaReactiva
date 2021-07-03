package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseEliminarRecurso {

    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;

    public UseCaseEliminarRecurso(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
    }

    public Mono<Void> delete(String id){
        return repositorioRecursos.deleteById(id);
    }
}
