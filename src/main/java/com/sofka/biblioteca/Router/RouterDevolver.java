package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseDevolver;
import com.sofka.biblioteca.UseCase.UseCasePrestarRecurso;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterDevolver {
    @Bean
    public RouterFunction<ServerResponse> devolver(UseCaseDevolver useCaseDevolver){
        return route(
                PUT("/devolver/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseDevolver.devolver(request.pathVariable("id")), RecursosDTO.class)
        );
    }

}
