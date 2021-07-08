package com.sofka.biblioteca.usecase;

import com.sofka.biblioteca.UseCase.UseCaseModificarRecursos;
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
class UseCaseModificarRecursosTest {


    @SpyBean
    private UseCaseModificarRecursos useCaseModificarRecursos;
    @MockBean
    private RepositorioRecursos repositorioRecursos;

    @Test
    public void modificarRecursosTest(){

        var recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");
        var recursoResponse= new Recursos();
        recursoResponse.setId("12");
        recursoResponse.setNombreRecurso("La biblia");
        recursoResponse.setDisponible(true);
        recursoResponse.setTipoRecurso("Libro");
        recursoResponse.setFechaPrestamo("02/02/2929");
        recursoResponse.setIdArea("xxx");

        when(repositorioRecursos.save(Mockito.any(Recursos.class))).thenReturn(Mono.just(recursoResponse));

        var spy = useCaseModificarRecursos.modify(recursosDTO);

        Assertions.assertEquals(spy.block() , "12");
    }
}