package com.sofka.biblioteca.Mapper;

import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.dto.RespuestaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperRespuesta {

    public Function<RecursosDTO, RespuestaDTO> DisponibilidadRecurso(){
        return recursodisponibilidad ->{
            var respuestaDTO = new RespuestaDTO();
            if(recursodisponibilidad.getDisponible()){
                respuestaDTO.setFechaPrestamo(null);
                respuestaDTO.setDisponible(true);
                respuestaDTO.setMensaje("El recurso " + recursodisponibilidad.getNombreRecurso() + " esta disponible");
                return respuestaDTO;
            }
            respuestaDTO.setFechaPrestamo(recursodisponibilidad.getFechaPrestamo());
            respuestaDTO.setDisponible(false);
            respuestaDTO.setMensaje("El recurso " + recursodisponibilidad.getNombreRecurso() + " no esta disponible");
            return respuestaDTO;
        };
    }
}
