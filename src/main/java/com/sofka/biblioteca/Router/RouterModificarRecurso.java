package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseCrearRecursos;
import com.sofka.biblioteca.UseCase.UseCaseModificarRecursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterModificarRecurso {

    @Bean
    public RouterFunction<ServerResponse> mofificarRecurso(UseCaseModificarRecursos useCaseModificarRecursos){
        return route(PUT("/modificar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursosDTO.class)
                        .flatMap(recursosDTO -> useCaseModificarRecursos.modify(recursosDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
