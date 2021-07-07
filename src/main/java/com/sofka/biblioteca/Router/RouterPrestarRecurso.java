package com.sofka.biblioteca.Router;

import com.sofka.biblioteca.UseCase.UseCaseDiponibilidadRecurso;
import com.sofka.biblioteca.UseCase.UseCasePrestarRecurso;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@Validated
public class RouterPrestarRecurso {

    @Bean
    public RouterFunction<ServerResponse> prestar(UseCasePrestarRecurso useCasePrestarRecurso){
        return route(
                PUT("/prestar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCasePrestarRecurso.prestar(request.pathVariable("id")), RecursosDTO.class)
        );
    }

}
