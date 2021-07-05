package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperAreaTematica;
import com.sofka.biblioteca.collections.AreaTematica;
import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.repository.RepositorioAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrearArea {

    private final RepositorioAreaTematica repositorioAreaTematica;
    private final MapperAreaTematica mapperAreaTematica;

    @Autowired
    public UseCaseCrearArea(RepositorioAreaTematica repositorioAreaTematica, MapperAreaTematica mapperAreaTematica) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.mapperAreaTematica = mapperAreaTematica;
    }

    public Mono<String> apply(AreaTematicaDTO areaTematicaDTO){
        var respuesta  = repositorioAreaTematica
                .save(mapperAreaTematica.mapperToArea(null)
                        .apply(areaTematicaDTO))
                        .map(AreaTematica::getIdArea);

        return respuesta;

    }
}
