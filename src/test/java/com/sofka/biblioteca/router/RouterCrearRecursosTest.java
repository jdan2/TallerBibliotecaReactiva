package com.sofka.biblioteca.router;

import com.sofka.biblioteca.Router.RouterCrearRecursos;
import com.sofka.biblioteca.UseCase.UseCaseCrearRecursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;


@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RouterCrearRecursos.class})
class RouterCrearRecursosTest {

    @MockBean
    private UseCaseCrearRecursos useCaseCrearRecursos;
    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void crearRecursoTest(){

        var recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");

        Mockito.when(useCaseCrearRecursos.apply(recursosDTO)).thenReturn(Mono.just(recursosDTO));

        webTestClient.post().uri("/crear")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(recursosDTO), RecursosDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursosDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getId()).isEqualTo(recursosDTO.getId());
                });

    }

}