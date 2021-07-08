package com.sofka.biblioteca.router;

import com.sofka.biblioteca.Router.RouterConsultarPorId;
import com.sofka.biblioteca.UseCase.UseCaseConsultarPorId;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RouterConsultarPorId.class})
class RouterConsultarPorIdTest {


    @MockBean
    private UseCaseConsultarPorId useCaseConsultarPorId;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void obtenerQuestionTest() {
        //arrange
        RecursosDTO recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");

        when(useCaseConsultarPorId.getbyid("12")).thenReturn(Mono.just(recursosDTO));

        webTestClient.get()
                .uri("/consultarporid/{id}","12")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursosDTO.class)
                .value(userResponse -> {
                            //comparar el questionDTO con el con el test http del cliente.

                            Assertions.assertThat(userResponse.getId()).isEqualTo(recursosDTO.getId());
                            Assertions.assertThat(userResponse.getNombreRecurso()).isEqualTo(recursosDTO.getNombreRecurso());
                            Assertions.assertThat(userResponse.getDisponible()).isEqualTo(recursosDTO.getDisponible());
                            Assertions.assertThat(userResponse.getTipoRecurso()).isEqualTo(recursosDTO.getTipoRecurso());
                            Assertions.assertThat(userResponse.getFechaPrestamo()).isEqualTo(recursosDTO.getFechaPrestamo());
                            Assertions.assertThat(userResponse.getIdArea()).isEqualTo(recursosDTO.getIdArea());
                        }


                );
    }

}