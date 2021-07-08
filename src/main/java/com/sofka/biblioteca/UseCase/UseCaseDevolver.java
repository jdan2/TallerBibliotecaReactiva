package com.sofka.biblioteca.UseCase;

import com.sofka.biblioteca.Mapper.MapperRecursos;
import com.sofka.biblioteca.Mapper.MapperRespuesta;
import com.sofka.biblioteca.dto.RespuestaDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Validated
public class UseCaseDevolver {
    private Date fechaActual = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    private final RepositorioRecursos repositorioRecursos;
    private final MapperRecursos mapperRecursos;
    private final MapperRespuesta mapperRespuesta;

    @Autowired
    public UseCaseDevolver(RepositorioRecursos repositorioRecursos, MapperRecursos mapperRecursos, MapperRespuesta mapperRespuesta) {
        this.repositorioRecursos = repositorioRecursos;
        this.mapperRecursos = mapperRecursos;
        this.mapperRespuesta = mapperRespuesta;
    }

    public Mono<RespuestaDTO> devolver(String id){
        var respuesta = repositorioRecursos.findById(id);

        var mensaje = new AtomicReference<>("Fue Devuelto");

        var resp = respuesta.flatMap(rs->{
            if(rs.getDisponible()){
                rs.setDisponible(true);
                rs.setFechaPrestamo(objSDF.format(fechaActual));

            }
            mensaje.set("No puedes devoler algo que no esta prestado");
            return  repositorioRecursos.save(rs);

        });

        return resp.map(mapperRespuesta.Devovler(mensaje.get()));
    }
}
