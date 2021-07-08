package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.collections.Recursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseModificarRecursos {
    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;

    public UseCaseModificarRecursos(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
    }

    public Mono<RecursosDTO> modify(RecursosDTO recursosDTO){
        return
                repositorioRecursos.save(mapperRecursos
                        .mapperToRecurso(recursosDTO.getId())
                        .apply(recursosDTO))
                        .map(mapperRecursos.mapRecursoToDTO());
    }
}
