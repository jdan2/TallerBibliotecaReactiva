package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.collections.Recursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrearRecursos {

    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;

    public UseCaseCrearRecursos(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
    }

    public Mono<String> apply(RecursosDTO recursosDTO){
        return repositorioRecursos.save(mapperRecursos.mapperToRecurso(null).apply(recursosDTO)).map(Recursos::getId);
    }

}
