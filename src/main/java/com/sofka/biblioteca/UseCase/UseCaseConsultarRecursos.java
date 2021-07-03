package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class UseCaseConsultarRecursos implements Supplier <Flux<RecursosDTO>>{

    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;

    public UseCaseConsultarRecursos(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
    }

    @Override
    public Flux<RecursosDTO> get() {
        return repositorioRecursos.findAll().map(mapperRecursos.mapRecursoToDTO());
    }
}
