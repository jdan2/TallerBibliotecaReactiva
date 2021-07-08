package com.sofka.biblioteca.router;

import com.sofka.biblioteca.Router.RouterEliminarRecurso;
import com.sofka.biblioteca.UseCase.UseCaseEliminarRecurso;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RouterEliminarRecurso.class})
class RouterEliminarRecursoTest {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private UseCaseEliminarRecurso useCaseEliminarRecurso;

    @Test
    public void DeleteUseCase(){

        Mockito.when(useCaseEliminarRecurso.delete("1")).thenReturn(Mono.empty());


        webTestClient.delete()
                .uri("/eliminar/{id}","1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Void.class)
                .value(response->{
                    Assertions.assertThat(response).isEqualTo(null);
                });


    }
}