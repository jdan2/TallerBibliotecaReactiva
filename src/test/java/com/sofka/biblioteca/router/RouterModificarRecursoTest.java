package com.sofka.biblioteca.router;

import com.sofka.biblioteca.Router.RouterModificarRecurso;
import com.sofka.biblioteca.UseCase.UseCaseModificarRecursos;
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
@ContextConfiguration(classes = {RouterModificarRecurso.class})
class RouterModificarRecursoTest {

    @MockBean
    private UseCaseModificarRecursos useCaseModificarRecursos;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void modificarQuestionRouterTest() {
        var recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");

        Mockito.when(useCaseModificarRecursos.modify(recursosDTO)).thenReturn(Mono.just(recursosDTO));

        webTestClient.put().uri("/modificar")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(recursosDTO), RecursosDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursosDTO.class)
                .value(response -> {
                    Assertions.assertThat(response.getId()).isEqualTo(recursosDTO.getId());
                });
    }

}