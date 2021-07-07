package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseConsultarPorId;
import com.sofka.biblioteca.UseCase.UseCaseConsultarRecursos;
import com.sofka.biblioteca.UseCase.UseCaseRecomendar;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRecomendar {
    @Bean
    public RouterFunction<ServerResponse> recomendar(UseCaseRecomendar useCaseRecomendar){
        return route(
                GET("/recomendar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseRecomendar.recomendar(request.pathVariable("id")), RecursosDTO.class)
        );
    }
}
