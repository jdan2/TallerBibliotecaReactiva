package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperAreaTematica;
import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.repository.RepositorioAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseConsultarArea {

    private final RepositorioAreaTematica repositorioAreaTematica;
    private final MapperAreaTematica mapperAreaTematica;

    @Autowired
    public UseCaseConsultarArea(RepositorioAreaTematica repositorioAreaTematica, MapperAreaTematica mapperAreaTematica) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.mapperAreaTematica = mapperAreaTematica;
    }


    public Flux<AreaTematicaDTO> get() {
        return repositorioAreaTematica.findAll().map(mapperAreaTematica.mapAreaToDTO());
    }
}
