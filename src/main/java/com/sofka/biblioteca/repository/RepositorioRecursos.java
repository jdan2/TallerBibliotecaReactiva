package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.collections.Recursos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioRecursos extends ReactiveMongoRepository <Recursos, String>{

    Flux<Recursos> findRecursosByidArea(String idArea);
}
