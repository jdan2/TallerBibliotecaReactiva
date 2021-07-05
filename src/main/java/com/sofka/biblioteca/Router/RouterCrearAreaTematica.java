package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseCrearArea;
import com.sofka.biblioteca.UseCase.UseCaseCrearRecursos;
import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCrearAreaTematica {
    @Bean
    public RouterFunction<ServerResponse> createArea(UseCaseCrearArea useCaseCrearArea){
        return route(POST("/creararea").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(AreaTematicaDTO.class)
                        .flatMap(areaTematicaDTO -> useCaseCrearArea.apply(areaTematicaDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
                        )
        );
    }
}
