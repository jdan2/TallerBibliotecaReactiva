package com.sofka.biblioteca.usecase;

import com.sofka.biblioteca.UseCase.UseCaseConsultarPorId;
import com.sofka.biblioteca.UseCase.UseCaseConsultarRecursos;
import com.sofka.biblioteca.collections.Recursos;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.repository.RepositorioRecursos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseConsultarPorIdTest {

    @SpyBean
    private UseCaseConsultarPorId useCaseConsultarPorId;

    @MockBean
    private RepositorioRecursos repositorioRecursos;

    @Test
    public void getRecurso() {

        var recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");
        var recursos = new Recursos();
        recursos.setId("12");
        recursos.setNombreRecurso("La biblia");
        recursos.setDisponible(true);
        recursos.setTipoRecurso("Libro");
        recursos.setFechaPrestamo("02/02/2929");
        recursos.setIdArea("xxx");

        when(repositorioRecursos.findById(Mockito.any(String.class))).thenReturn(Mono.just(recursos));

        var respuesta = useCaseConsultarPorId.getbyid(recursosDTO.getId());

        Assertions.assertEquals(respuesta.block().getId(), "12");

    }
}