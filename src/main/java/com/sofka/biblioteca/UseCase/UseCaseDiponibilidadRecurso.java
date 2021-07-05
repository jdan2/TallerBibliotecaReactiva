package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.Mapper.MapperRespuesta;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.dto.RespuestaDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseDiponibilidadRecurso {

    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;
    private final MapperRespuesta mapperRespuesta;

    public UseCaseDiponibilidadRecurso(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos, MapperRespuesta mapperRespuesta) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
        this.mapperRespuesta = mapperRespuesta;
    }

    public Mono<RespuestaDTO> disponibilidad(String id){
        var respuesta = repositorioRecursos.findById(id).map(mapperRecursos.mapRecursoToDTO());
        return respuesta.map(mapperRespuesta.DisponibilidadRecurso());
    }
}
