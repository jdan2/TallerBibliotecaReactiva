package com.sofka.biblioteca.usecase;

import com.sofka.biblioteca.UseCase.UseCaseEliminarRecurso;
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

@SpringBootTest
class UseCaseEliminarRecursoTest {


    @MockBean
    private RepositorioRecursos repositorioRecursos;

    @SpyBean
    UseCaseEliminarRecurso useCaseEliminarRecurso;

    @Test
    public void eliminarQuestionTest(){

        var recursosDTO = new RecursosDTO("12","La biblia", true, "Libro", "02/02/2929", "xxx");


        Mockito.when(repositorioRecursos.deleteById("12")).thenReturn(Mono.empty());

        var datos = useCaseEliminarRecurso.delete("12").block();

        Assertions.assertEquals(datos,null);
    }
}