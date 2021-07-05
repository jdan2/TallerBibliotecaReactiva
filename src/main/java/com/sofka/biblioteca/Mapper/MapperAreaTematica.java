package com.sofka.biblioteca.Mapper;

import com.sofka.biblioteca.collections.AreaTematica;
import com.sofka.biblioteca.dto.AreaTematicaDTO;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class MapperAreaTematica {

    public Function<AreaTematicaDTO, AreaTematica> mapperToArea(String id){
        return updateAreaTematica ->{
            AreaTematica area = new AreaTematica();
            area.setIdArea(id);
            area.setNombreArea(updateAreaTematica.getNombreArea());
            return area;
        };
    }

    public Function<AreaTematica, AreaTematicaDTO> mapAreaToDTO(){
        return entity -> new AreaTematicaDTO(entity.getIdArea(), entity.getNombreArea());
    }
}
