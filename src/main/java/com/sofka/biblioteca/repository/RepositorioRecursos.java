package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.collections.Recursos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioRecursos extends ReactiveMongoRepository <Recursos, String>{
}
