package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseCrearRecursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCrearRecursos {
    @Bean
    public RouterFunction<ServerResponse> createRecurso(UseCaseCrearRecursos useCaseCrearRecursos){
        return route(POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursosDTO.class)
                .flatMap(recursosDTO -> useCaseCrearRecursos.apply(recursosDTO)
                  .flatMap(result-> ServerResponse.ok()
                       .contentType(MediaType.TEXT_PLAIN)
                         .bodyValue(result))
        )
        );
    }
}
