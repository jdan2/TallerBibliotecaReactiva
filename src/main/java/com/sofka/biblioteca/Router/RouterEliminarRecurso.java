package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseCrearRecursos;
import com.sofka.biblioteca.UseCase.UseCaseEliminarRecurso;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterEliminarRecurso {
    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(UseCaseEliminarRecurso UseCaseEliminarRecurso){
        return route(DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                            .body(UseCaseEliminarRecurso.delete(request.pathVariable("id")), RecursosDTO.class)

        );
    }
}
