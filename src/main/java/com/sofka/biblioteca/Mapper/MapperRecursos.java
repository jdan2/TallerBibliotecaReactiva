package com.sofka.biblioteca.Mapper;

import com.sofka.biblioteca.collections.Recursos;
import org.springframework.stereotype.Component;
import com.sofka.biblioteca.dto.RecursosDTO;
import java.util.function.Function;

@Component
public class MapperRecursos {

    public Function<RecursosDTO, Recursos> mapperToRecurso(String id){
        return updateRecurso ->{
            var recurso = new Recursos();
            recurso.setId(id);
            recurso.setTipoRecurso(updateRecurso.getTipoRecurso());
            recurso.setNombreRecurso(updateRecurso.getNombreRecurso());
            recurso.setDisponible(updateRecurso.getDisponible());
            recurso.setFechaPrestamo(updateRecurso.getFechaPrestamo());
            recurso.setIdArea(updateRecurso.getIdArea());
            return recurso;
        };
    }

    public Function<Recursos, RecursosDTO> mapRecursoToDTO(){
        return entity -> new RecursosDTO(entity.getId(), entity.getNombreRecurso(), entity.getDisponible(),
                entity.getTipoRecurso(), entity.getFechaPrestamo(), entity.getIdArea());
    }

}
